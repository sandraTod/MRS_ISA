import { Component, OnInit } from '@angular/core';
import { ComplaintService } from 'src/app/services/complaint.service';

@Component({
  selector: 'app-admin-complaints',
  templateUrl: './admin-complaints.component.html',
  styleUrls: ['./admin-complaints.component.css']
})
export class AdminComplaintsComponent implements OnInit {

  complaints: any[] = [];
selectedComplaintId: number | null = null;
responseText: string = '';

constructor(private complaintService: ComplaintService) {}

ngOnInit() {
  this.loadComplaints();
}

loadComplaints() {
  this.complaintService.getAll().subscribe(res => {
    this.complaints = res;
  });
}

getTypeLabel(type: string): string {
  switch(type) {
    case 'COTTAGE': return 'Vikendica';
    case 'SHIP': return 'Brod';
    case 'ADVENTURE': return 'Avantura';
    case 'COTTAGE_OWNER': return 'Vlasnik vikendice';
    case 'SHIP_OWNER': return 'Vlasnik broda';
    case 'INSTRUCTOR': return 'Instruktor';
    default: return type;
  }
}

selectComplaint(id: number){

}

  

}
