import { Component, OnInit } from '@angular/core';
import { DeletionService } from 'src/app/services/deletion.service';

@Component({
  selector: 'app-deletion-requests-admin',
  templateUrl: './deletion-requests-admin.component.html',
  styleUrls: ['./deletion-requests-admin.component.css']
})
export class DeletionRequestsAdminComponent implements OnInit {

  requests: any[] = [];
  selectedId: number | null = null;
  responseText: string = '';
  status: string = 'APPROVED';

  constructor(private deletionService: DeletionService) { }

  ngOnInit() {
    this.load();
  }

  load() {
    this.deletionService.getAll().subscribe(res => {
      this.requests = res;
    });
  }

  select(id: number) {
    this.selectedId = id;
  }

  getStatusLabel(status: string): string {
    switch(status) {
      case 'APPROVED': return 'Prihvaćeno';
      case 'REJECTED': return 'Odbijeno';
      case 'PENDING': return 'Na čekanju';
      default: return status;
    }
  }

  sendResponse() {
    
    const dto = {
      response: this.responseText,
      status: this.status
    };
    this.deletionService.respond(this.selectedId!, dto).subscribe(() => {
      this.load();
      this.selectedId = null;
      this.responseText = '';
    });
  }

}
