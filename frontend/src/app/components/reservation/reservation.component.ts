import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ReservationService } from 'src/app/services/reservation.service';
import { threadId } from 'worker_threads';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  constructor(private fb: FormBuilder, private reservationService: ReservationService) { }

  todayDateTime! : string
  resourceList!: any;
  noResults: boolean = false;
  selectedResource: any = false;
  showModal: boolean = false;

  searchForm = this.fb.group({
    entity: ['Vikendice', Validators.required],
    dateFrom: ['', Validators.required],
    dateTo: ['', Validators.required],
    city: [''],
    numOfPeople: [0],
  });

  ngOnInit(): void {

    const now = new Date();

    const year = now.getFullYear();
    const month = String(now.getMonth() + 1).padStart(2, '0');
    const day = String(now.getDate()).padStart(2, '0');
    const hours = String(now.getHours()).padStart(2, '0');
    const minutes = String(now.getMinutes()).padStart(2, '0');
  
    this.todayDateTime = `${year}-${month}-${day}T${hours}:${minutes}`;
  }

  onSearch(){

    if (this.searchForm.invalid) {
      this.searchForm.markAllAsTouched();
      return;
      
    }
    console.log(this.searchForm.value);
  
    this.reservationService.search(this.searchForm.value)
      .subscribe(data => {
       this.resourceList = data;
       console.log(this.resourceList);
       this.noResults = this.resourceList.length === 0;
      });

  }

  reset() {
   this.searchForm = this.fb.group({
      entity: ['Vikendice', Validators.required],
      dateFrom: ['', Validators.required],
      dateTo: ['', Validators.required],
      city: [''],
      numOfPeople: [0],
    });
    this.noResults = false;
  }
  openDetails(resource: any){
    this.selectedResource = resource;
    this.showModal = true;

  }
  closeModal(){
    this.showModal = false; 
  }



}
