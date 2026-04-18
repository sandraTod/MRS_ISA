import { DeletionService } from './../../services/deletion.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-deletion-request',
  templateUrl: './deletion-request.component.html',
  styleUrls: ['./deletion-request.component.css']
})
export class DeletionRequestComponent implements OnInit {

  text:string = '';
  
  constructor(private deletionService : DeletionService) { }

  ngOnInit(): void {
  }


  sendRequest() {
    const dto = {
      text: this.text
    };
  
    this.deletionService.create(dto).subscribe(() => {
      alert("Request sent successfully!");
      this.text = '';
    });
  }

}
