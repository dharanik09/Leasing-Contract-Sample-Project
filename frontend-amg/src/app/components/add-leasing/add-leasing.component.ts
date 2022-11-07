import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer.model';
import { Leasing } from 'src/app/models/leasing.model';
import { Vehicle } from 'src/app/models/vehicle.model';
import { LeasingService } from 'src/app/services/leasing.service';

@Component({
  selector: 'app-add-leasing',
  templateUrl: './add-leasing.component.html',
  styleUrls: ['./add-leasing.component.css']
})
export class AddLeasingComponent implements OnInit {

  leasing: Leasing = {
    id: '',
    contractNumber:  '',
    monthlyRate:  '',
    customer: [],//new Customer,
    vehicle: [],
    vehicle_id:'',
    customer_id:'',
    VIN: '',
    price: ''
  };
  showData: any[] = [];


  customer: Customer = {
    id: '',
    first_name: '',
    last_name: '',
    birthdate: ''
  };

  submitted = false;
  
  constructor(private leasingService: LeasingService) { }

  ngOnInit(): void {
    this.retrieveCustomer();
    this.retrieveVehicle();
  }
  
  selectCustomer?: Customer[];
  selectVehicle?: Vehicle[];

  retrieveCustomer(): void {
    this.leasingService.getAllCustomerDetails()
      .subscribe({
        next: (data) => {
          this.selectCustomer = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  retrieveVehicle(): void {
    this.leasingService.getAllVehicleDetails()
      .subscribe({
        next: (data) => {
          this.selectVehicle = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }


  saveLeasing(): void {

    const data = {
      id: this.leasing.id,
      contractNumber: this.leasing.contractNumber,
      monthlyRate: this.leasing.monthlyRate,
      "customer":{id: this.leasing.customer_id},
      "vehicle":{id: this.leasing.vehicle_id,}
    };
/*

    this.leasingService.getCustomer(data.customer_id)
    .subscribe({
      next: (data) => {
        this.customer = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    })
*/
    this.leasingService.create(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }

  newLeasing(): void {
    this.submitted = false;
    this.leasing = {
      id: '',
      contractNumber:  '',
      monthlyRate:  '',
      customer: [],//new Customer,
      vehicle: [],
      vehicle_id:'',
      customer_id:'',

      VIN: '',
      price: ''
      };
  }

}
