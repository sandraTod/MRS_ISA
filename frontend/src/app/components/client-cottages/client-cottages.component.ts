import { CottageService } from './../../services/cottage.service';
import { Component, OnInit } from '@angular/core';
import { Cottage } from 'src/app/model/cottage';

@Component({
  selector: 'app-client-cottages',
  templateUrl: './client-cottages.component.html',
  styleUrls: ['./client-cottages.component.css']
})
export class ClientCottagesComponent implements OnInit {

  cottageList!: Cottage[];

  constructor(private cottageService: CottageService ) { }

  ngOnInit(): void {
     
    this.getAllCottages();

  }
  getAllCottages(){
    
    this.cottageService.getAllCottages().subscribe(data => {
      this.cottageList = data; 
      console.log(this.cottageList); })
  }

  


}
