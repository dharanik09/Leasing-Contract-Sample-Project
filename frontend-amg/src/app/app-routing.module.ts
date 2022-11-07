import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { CustomerDetailsComponent } from './components/customer-details/customer-details.component';
import { AddCustomerComponent } from './components/add-customer/add-customer.component';

import { VehicleListComponent } from './components/vehicle-list/vehicle-list.component';
import { VehicleDetailsComponent } from './components/vehicle-details/vehicle-details.component';
import { AddVehicleComponent } from './components/add-vehicle/add-vehicle.component';

import { LeasingListComponent } from './components/leasing-list/leasing-list.component';
import { LeasingDetailsComponent } from './components/leasing-details/leasing-details.component';
import { AddLeasingComponent } from './components/add-leasing/add-leasing.component';

const routes: Routes = [
  { path: '', redirectTo: 'leasing', pathMatch: 'full' },
  { path: 'customer', component: CustomerListComponent },
  { path: 'customer/add', component: AddCustomerComponent },
  { path: 'customer/:id', component: CustomerDetailsComponent },

  { path: 'vehicle', component: VehicleListComponent },
  { path: 'vehicle/add', component: AddVehicleComponent },
  { path: 'vehicle/:id', component: VehicleDetailsComponent },

  { path: 'leasing', component: LeasingListComponent },
  { path: 'leasing/add', component: AddLeasingComponent },
  { path: 'leasing/:id', component: LeasingDetailsComponent },

  { path: 'add', component: AddCustomerComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
