import { Adventure } from './../../model/adventure';
import { Component, OnInit } from '@angular/core';
import { AdventureService } from 'src/app/services/adventure.service';

@Component({
  selector: 'app-adventures',
  templateUrl: './adventures.component.html',
  styleUrls: ['./adventures.component.css']
})
export class AdventuresComponent implements OnInit {

  constructor(private adventureService: AdventureService) { }

  adventureList!: Adventure[];

  ngOnInit(): void {

    this.getAllAdventures();

  }

  getAllAdventures(){ 
    this.adventureService.getAllAdventures().subscribe(data => {
      this.adventureList = data; 
      console.log(this.adventureList); })
  }

}
