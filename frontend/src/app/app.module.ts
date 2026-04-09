import {  HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { TokenInterceptorService } from './services/token-interceptor.service';
import { UserService } from './services/user.service';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { ClientPageComponent } from './components/client-page/client-page.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { CottagesComponent } from './components/cottages/cottages.component';
import { ShipsComponent } from './components/ships/ships.component';
import { AdventuresComponent } from './components/adventures/adventures.component';
import { ClientProfileComponent } from './components/client-profile/client-profile.component';
import { ReservationComponent } from './components/reservation/reservation.component';
import { CottageDetailsComponent } from './components/cottage-details/cottage-details.component';
import { ShipDetailsComponent } from './components/ship-details/ship-details.component';
import { AdventureDetailsComponent } from './components/adventure-details/adventure-details.component';
import { MyReservationsComponent } from './components/my-reservations/my-reservations.component';
import { FastReservationsComponent } from './components/fast-reservations/fast-reservations.component';
import { ClientCottagesComponent } from './components/client-cottages/client-cottages.component';
import { ClientShipsComponent } from './components/client-ships/client-ships.component';
import { ClientAdventuresComponent } from './components/client-adventures/client-adventures.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminPageComponent,
    ClientPageComponent,
    RegistrationComponent,
    CottagesComponent,
    ShipsComponent,
    AdventuresComponent,
    ClientProfileComponent,
    ReservationComponent,
    CottageDetailsComponent,
    ShipDetailsComponent,
    AdventureDetailsComponent,
    MyReservationsComponent,
    FastReservationsComponent,
    ClientCottagesComponent,
    ClientShipsComponent,
    ClientAdventuresComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    UserService,
    HttpClient,
    {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
