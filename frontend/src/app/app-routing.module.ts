import { ShipsComponent } from './components/ships/ships.component';
import { CottagesComponent } from './components/cottages/cottages.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientPageComponent } from './components/client-page/client-page.component';

const routes: Routes = [
  { path: "loginPage", component: LoginComponent},
  { path: "adminPage", component: AdminPageComponent},
  { path: "clientPage", component: ClientPageComponent},
  { path: "registration", component: RegistrationComponent},
  { path: "cottages" , component: CottagesComponent},
  { path: "ships" , component: ShipsComponent},
  { path: '', component: CottagesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }