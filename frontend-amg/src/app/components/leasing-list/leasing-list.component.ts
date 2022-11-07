import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/models/customer.model';
import { Leasing } from 'src/app/models/leasing.model';
import { Vehicle } from 'src/app/models/vehicle.model';
import { LeasingService } from 'src/app/services/leasing.service';

@Component({
  selector: 'app-leasing-list',
  templateUrl: './leasing-list.component.html',
  styleUrls: ['./leasing-list.component.css']
})
export class LeasingListComponent implements OnInit {

  showData: any[] = [];

  leasing?: Leasing[];
  currentIndex = -1;
  title = '';
  public customerId: number=0;
  public customerId2: number=0;
  public vehicleId: number=0;

  constructor(
    private leasingService: LeasingService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.retrieveLeasing();
  }

  ngOnChanges(): void {
    this.customerId2 = this.customerId;
  }

  retrieveLeasing(): void {
    this.leasingService.getAll()
      .subscribe({
        next: (data) => {
          //this.leasing = data;
          this.showData = data;
          console.log("Data",data);
        },
        error: (e) => console.error(e)
      });
  }

  refreshList(): void {
    this.retrieveLeasing();
    this.currentIndex = -1;
  }

  setActiveLeasing(leasing: Leasing, index: number): void {
    this.currentIndex = index;
  }

  removeAllLeasings(): void {
    this.leasingService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }

  searchTitle(): void {
    this.currentIndex = -1;

    this.leasingService.findByTitle(this.title)
      .subscribe({
        next: (data) => {
          this.leasing = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  deleteLeasing(index: number): void {
    this.leasingService.delete(index)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/Leasing']);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }

  setCustomerParams(customers: Customer[]){

    customers.forEach(x=> this.customerId = x.id);
    console.log("CustomerId 2: ",this.customerId);
  }

  setVehicleParams(vehicle: Vehicle){
      this.vehicleId= vehicle.id;
      console.log("VehicleId 2: ",this.vehicleId);
    
  }
}
