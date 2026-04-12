import { Component, OnInit } from '@angular/core';
import { Adventure } from 'src/app/model/adventure';
import { AdventureService } from 'src/app/services/adventure.service';

@Component({
  selector: 'app-client-adventures',
  templateUrl: './client-adventures.component.html',
  styleUrls: ['./client-adventures.component.css']
})
export class ClientAdventuresComponent implements OnInit {

  adventureList!: Adventure[];

  constructor(private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.getAllAdventures();
  }

  getAllAdventures(){ 
    this.adventureService.getAllAdventures().subscribe(data => {
      this.adventureList = data; 
      console.log(this.adventureList); })
  }

}
