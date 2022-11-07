import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { Customer } from 'src/app/models/customer.model';
import { Leasing } from 'src/app/models/leasing.model';
import { Vehicle } from 'src/app/models/vehicle.model';
import { LeasingService } from 'src/app/services/leasing.service';

@Component({
  selector: 'app-leasing-details',
  templateUrl: './leasing-details.component.html',
  styleUrls: ['./leasing-details.component.css']
})
export class LeasingDetailsComponent implements OnInit {

  @Input() viewMode = false;

  @Input() currentLeasing: Leasing = {
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
  customer: Customer = {
    id: '',
    first_name: '',
    last_name: '',
    birthdate: ''
  };
  
  message = '';

  constructor(
    private leasingService: LeasingService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
     if (!this.viewMode) {
       this.message = '';
       this.getLeasing(this.route.snapshot.params["id"]);
     }
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


  getLeasing(id: string): void {
    this.leasingService.get(id)
      .subscribe({
        next: (data) => {
          this.currentLeasing = data;
           let obj2=[] as any;
           obj2 = Object.assign({}, data.customer);
           this.currentLeasing.customer_id = obj2.id;
      
           let obj3=[] as any;
           obj3 = Object.assign({}, data.vehicle);
           this.currentLeasing.vehicle_id = obj3.id;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  updatePublished(status: boolean): void {
    const data = {
      id: this.currentLeasing.id,
      contractNumber: this.currentLeasing.contractNumber,
      monthlyRate: this.currentLeasing.monthlyRate,
      "customer":{id: this.currentLeasing.customer_id},
      "vehicle":{id: this.currentLeasing.vehicle_id,}
    };

    this.message = '';

    this.leasingService.update(this.currentLeasing.id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
             this.message = res.message ? res.message : 'The status was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  updateLeasing(): void {
    this.message = '';
    const data = {
      id: this.currentLeasing.id,
      contractNumber: this.currentLeasing.contractNumber,
      monthlyRate: this.currentLeasing.monthlyRate,
      "customer":{id: this.currentLeasing.customer_id},
      "vehicle":{id: this.currentLeasing.vehicle_id,}
    };

    this.leasingService.update(this.currentLeasing.id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This Leasing was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  deleteLeasing(): void {
    this.leasingService.delete(this.currentLeasing.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/Leasing']);
        },
        error: (e) => console.error(e)
      });
  }

}
