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
