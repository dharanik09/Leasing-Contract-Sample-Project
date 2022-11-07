import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddCustomerComponent } from './components/add-customer/add-customer.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CustomerDetailsComponent } from './components/customer-details/customer-details.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { AddVehicleComponent } from './components/add-vehicle/add-vehicle.component';
import { VehicleDetailsComponent } from './components/vehicle-details/vehicle-details.component';
import { VehicleListComponent } from './components/vehicle-list/vehicle-list.component';
import { AddLeasingComponent } from './components/add-leasing/add-leasing.component';
import { LeasingDetailsComponent } from './components/leasing-details/leasing-details.component';
import { LeasingListComponent } from './components/leasing-list/leasing-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddCustomerComponent,
    CustomerDetailsComponent,
    CustomerListComponent,
    AddVehicleComponent,
    VehicleDetailsComponent,
    VehicleListComponent,
    AddLeasingComponent,
    LeasingDetailsComponent,
    LeasingListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
