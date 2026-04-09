import { ReservationService } from 'src/app/services/reservation.service';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-fast-reservations',
  templateUrl: './fast-reservations.component.html',
  styleUrls: ['./fast-reservations.component.css']
})
export class FastReservationsComponent implements OnInit {
   
  @Input() resourceType!: string;
  reservations!: any[];

  constructor(private reservationService: ReservationService) { }

  ngOnInit(): void {
    this.loadReservations();
  }


  loadReservations() {
    this.reservationService.getFastReservations(this.resourceType).subscribe(res => {
      this.reservations = res;
    });
  }

  


  reserve(id: number) {
    this.reservationService.reserveFast(id).subscribe({
      next: () => {
        alert("Rezervacija uspesno izvrsena! 🎉");
        this.loadReservations(); // refresh liste
      },
      error: () => {
        alert("Something went wrong 😢");
      }
    });
  }

}
