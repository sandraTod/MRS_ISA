import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-my-reservations',
  templateUrl: './my-reservations.component.html',
  styleUrls: ['./my-reservations.component.css']
})
export class MyReservationsComponent implements OnInit {

  constructor(private reservationService: ReservationService) { }

  reservations!: any[];


  ngOnInit() {
    this.loadReservations();
  }
  
  loadReservations() {
  
    this.reservationService.getMyReservations().subscribe(res => {
      this.reservations = res;
      console.log(this.reservations);
    });
  }

  isTooLate(startDate: string): boolean {
    const now = new Date();
    const start = new Date(startDate);
  
    const diff = (start.getTime() - now.getTime()) / (1000 * 60 * 60 * 24);
  
    return diff < 3;
  }

  cancelReservation(id: number) {
    this.reservationService.cancelReservation(id).subscribe({
      next: () => {
        alert("Reservation cancelled!");
        this.loadReservations();
      },
      error: (err) => {
        alert(err.error?.message || "Cannot cancel reservation");
      }
    });
  }

}
