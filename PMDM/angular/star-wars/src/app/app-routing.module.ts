import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehiclesListComponent } from './components/vehicles-list/vehicles-list.component';
import { PeopleListComponent } from './components/people-list/people-list.component';

const routes: Routes = [
  { path: 'vehicles', component: VehiclesListComponent },
  { path: 'people', component: PeopleListComponent },
  { path: '', redirectTo: '/vehicles', pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
