import { CottageService } from './../../services/cottage.service';
import { Cottage } from './../../model/cottage';
import { Component, OnInit } from '@angular/core';
import { Filter } from 'src/app/model/filter';

@Component({
  selector: 'app-cottages',
  templateUrl: './cottages.component.html',
  styleUrls: ['./cottages.component.css']
})
export class CottagesComponent implements OnInit {

  cottageList!: Cottage[];
  filter = {
    name: null,
    city: null,
    minGrade: null,

  }

  constructor(private cottageService: CottageService) { }

  ngOnInit(): void {
     
    this.getAllCottages();

  }
  getAllCottages(){
    
    this.cottageService.getAllCottages().subscribe(data => {
      this.cottageList = data; 
      console.log(this.cottageList); })
  }

  filterCottage(){
    console.log(this.filter);
    this.cottageService.filter(this.filter).subscribe((data: any) => { this.cottageList = data;console.log(data)})
  }
  reset() {
    this.filter = {
      name: null,
      city: null,
      minGrade: null
    };
    this.getAllCottages(); // vrati sve
  }



}
