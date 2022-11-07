import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/models/customer.model';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {


  customers?: Customer[];
  currentCustomer: Customer = {};
  currentIndex = -1;
  title = '';

  constructor(
    private customerService: CustomerService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.retrieveCustomer();
  }

  retrieveCustomer(): void {
    this.customerService.getAll()
      .subscribe({
        next: (data) => {
          this.customers = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  refreshList(): void {
    this.retrieveCustomer();
    this.currentCustomer = {};
    this.currentIndex = -1;
  }

  setActiveCustomer(customer: Customer, index: number): void {
    this.currentCustomer = customer;
    this.currentIndex = index;
  }

  removeAllCustomers(): void {
    this.customerService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }

  searchTitle(): void {
    this.currentCustomer = {};
    this.currentIndex = -1;

    this.customerService.findByTitle(this.title)
      .subscribe({
        next: (data) => {
          this.customers = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  deleteCustomer(index: number): void {
    this.customerService.delete(index)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/customer']);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }
}
