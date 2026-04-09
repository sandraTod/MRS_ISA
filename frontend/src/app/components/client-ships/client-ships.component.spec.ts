import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientShipsComponent } from './client-ships.component';

describe('ClientShipsComponent', () => {
  let component: ClientShipsComponent;
  let fixture: ComponentFixture<ClientShipsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientShipsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientShipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
