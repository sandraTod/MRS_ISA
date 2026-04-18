import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletionRequestsAdminComponent } from './deletion-requests-admin.component';

describe('DeletionRequestsAdminComponent', () => {
  let component: DeletionRequestsAdminComponent;
  let fixture: ComponentFixture<DeletionRequestsAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletionRequestsAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletionRequestsAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
