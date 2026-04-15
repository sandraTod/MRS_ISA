import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ComplaintService } from 'src/app/services/complaint.service';

@Component({
  selector: 'app-complaint',
  templateUrl: './complaint.component.html',
  styleUrls: ['./complaint.component.css']
})
export class ComplaintComponent implements OnInit {

  text: string = '';
type!: string;
targetId!: number;

constructor(
  private route: ActivatedRoute,
  private complaintService: ComplaintService
) {}

ngOnInit(): void {
  this.route.queryParams.subscribe(params => {
    this.type = params['type'];
    this.targetId = +params['targetId'];
  });
}

submit() {
  const dto = {
    text: this.text,
    type: this.type,
    targetId: this.targetId
  };

  this.complaintService.createComplaint(dto).subscribe(() => {
    alert("Complaint sent successfully!");
    this.text = '';
  });
}

}
