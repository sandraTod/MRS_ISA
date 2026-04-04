import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ConnectableObservable } from 'rxjs';
import { ReservationRequest } from 'src/app/model/reservation-request';
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
  selectedServices: string[] = [];
  showReservationModal = false;
  showConfirmModal = false;
  numOfPeople!: any;
  totalPrice!: any;

  reservationReq: ReservationRequest = {
    "resourceId": 0,
    "startDate":'',
    "endDate" : '',
    "numOfPeople": 0,
    "maxNumPeople": 0,
    "selectedServices": []
  
  }  
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
    
    this.numOfPeople = this.searchForm.value.numOfPeople
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

    this.calculatePrice();

  }
  closeModal(){
    this.showModal = false; 
  }

  onSortChange(value: string) {

    switch(value) {
      case 'priceAsc':
        this.resourceList.sort((a: any, b: any) => a.pricePerDay - b.pricePerDay);
        break;
      case 'priceDesc':
        this.resourceList.sort((a: any, b: any) => b.pricePerDay - a.pricePerDay);
        break;
      case 'ratingAsc':
        this.resourceList.sort((a: any, b: any) => a.avgGrade - b.avgGrade);
        break;
      case 'ratingDesc':
        this.resourceList.sort((a: any, b: any) => b.avgGrade - a.avgGrade);
        break;
    }
  
    this.resourceList = [...this.resourceList];
  }

  

  onServicesChanged(services: string[]) {
    this.selectedServices = services;
  }

  openReservation() {
    this.showReservationModal = true;
  }


  calculatePrice(){

    this.reservationReq = {
      "resourceId": this.selectedResource.id,
      "startDate": this.searchForm.value.dateFrom,
      "endDate" : this.searchForm.value.dateTo,
      "numOfPeople": this.numOfPeople,
      "maxNumPeople": this.selectedResource.capacity,
      "selectedServices": []
    }  

    this.reservationService.calculatePrice(this.reservationReq)
    .subscribe(price => {
      this.totalPrice = price;
      console.log(price);
    });
  }

  openConfirmModal(resource: any) {
    this.selectedResource = resource;
  
    this.reservationReq.resourceId = resource.id;
    this.reservationReq.selectedServices  = this.selectedServices
    this.reservationReq.maxNumPeople = resource.maxNumOfPeople;

  
    this.calculatePrice();
  
    this.showConfirmModal = true;
  }
  closeConfirmModal() {
    this.showConfirmModal = false;
  }
  confirmReservation(){
    this.reservationService.createReservation(this.reservationReq)
    .subscribe({
      next: () => {
        alert("Reservation successful 😄");
        this.closeConfirmModal();
        this.cancelReservation();
      },
      error: () => {
        alert("Something went wrong 😬");
      }
    });
  }

  cancelReservation(){
    this.showReservationModal = false
    this.numOfPeople =  this.searchForm.value.numOfPeople;
    console.log(this.numOfPeople);

  }
  onPeopleChange() {
    if (this.reservationReq.numOfPeople > this.reservationReq.maxNumPeople) {
      this.reservationReq.numOfPeople = this.reservationReq.maxNumPeople;
    }
  
    if (this.reservationReq.numOfPeople < 1) {
      this.reservationReq.numOfPeople = 1;
    }
  
    this.calculatePrice();
  }

  



}
