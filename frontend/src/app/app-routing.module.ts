import { AdminComplaintsComponent } from './components/admin-complaints/admin-complaints.component';
import { ComplaintComponent } from './components/complaint/complaint.component';
import { SubscriptionsComponent } from './components/subscriptions/subscriptions.component';
import { FastReservationsComponent } from './components/fast-reservations/fast-reservations.component';
import { ClientCottagesComponent } from './components/client-cottages/client-cottages.component';
import { MyReservationsComponent } from './components/my-reservations/my-reservations.component';
import { ReservationComponent } from './components/reservation/reservation.component';
import { ClientProfileComponent } from './components/client-profile/client-profile.component';
import { AdventuresComponent } from './components/adventures/adventures.component';
import { ShipsComponent } from './components/ships/ships.component';
import { CottagesComponent } from './components/cottages/cottages.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientPageComponent } from './components/client-page/client-page.component';
import { ClientShipsComponent } from './components/client-ships/client-ships.component';
import { ClientAdventuresComponent } from './components/client-adventures/client-adventures.component';

const routes: Routes = [
  { path: "loginPage", component: LoginComponent},
  { path: "adminPage", component: AdminPageComponent},
  { path: "clientPage", component: ClientPageComponent},
  { path: "client-cottages", component: ClientCottagesComponent},
  { path: "client-ships", component: ClientShipsComponent},
  { path: "client-adventures", component: ClientAdventuresComponent},
  { path: "registration", component: RegistrationComponent},
  { path: "cottages" , component: CottagesComponent},
  { path: "ships" , component: ShipsComponent},
  { path: "adventure" , component: AdventuresComponent},
  { path: "clientProfile", component: ClientProfileComponent},
  { path: "reservation", component: ReservationComponent},
  { path: "myReservations", component: MyReservationsComponent},
  { path: "fast-reservations", component: FastReservationsComponent},
  { path: "subscriptions", component: SubscriptionsComponent},
  { path: "complaint", component: ComplaintComponent},
  { path: "admin-complaints", component: AdminComplaintsComponent},
  { path: '', component: CottagesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }