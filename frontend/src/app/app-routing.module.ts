import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientPageComponent } from './components/client-page/client-page.component';

const routes: Routes = [
  { path: "loginPage", component: LoginComponent},
  { path: "adminPage", component: AdminPageComponent},
  { path: "clientPage", component: ClientPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }