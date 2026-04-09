import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientCottagesComponent } from './client-cottages.component';

describe('ClientCottagesComponent', () => {
  let component: ClientCottagesComponent;
  let fixture: ComponentFixture<ClientCottagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientCottagesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientCottagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
