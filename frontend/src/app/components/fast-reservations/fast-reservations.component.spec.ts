import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FastReservationsComponent } from './fast-reservations.component';

describe('FastReservationsComponent', () => {
  let component: FastReservationsComponent;
  let fixture: ComponentFixture<FastReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FastReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FastReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
