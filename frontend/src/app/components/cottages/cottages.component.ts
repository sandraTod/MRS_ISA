import { CottageService } from './../../services/cottage.service';
import { Cottage } from './../../model/cottage';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cottages',
  templateUrl: './cottages.component.html',
  styleUrls: ['./cottages.component.css']
})
export class CottagesComponent implements OnInit {

  cottageList!: Cottage[];

  constructor(private cottageService: CottageService) { }

  ngOnInit(): void {

    this.cottageService.getAllCottages().subscribe(data => {
      this.cottageList = data; 
      console.log(this.cottageList); })

  }



}
