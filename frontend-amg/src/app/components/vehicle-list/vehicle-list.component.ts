import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vehicle } from 'src/app/models/vehicle.model';
import { VehicleService } from 'src/app/services/vehicle.service';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {

  vehicle?: Vehicle[];
  currentVehicle: Vehicle = {};
  currentIndex = -1;
  title = '';

  constructor(
    private vehicleService: VehicleService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.retrieveVehicle();
  }

  retrieveVehicle(): void {
    this.vehicleService.getAll()
      .subscribe({
        next: (data) => {
          this.vehicle = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  refreshList(): void {
    this.retrieveVehicle();
    this.currentVehicle = {};
    this.currentIndex = -1;
  }

  setActiveVehicle(Vehicle: Vehicle, index: number): void {
    this.currentVehicle = Vehicle;
    this.currentIndex = index;
  }

  removeAllVehicles(): void {
    this.vehicleService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }

  searchTitle(): void {
    this.currentVehicle = {};
    this.currentIndex = -1;

    this.vehicleService.findByTitle(this.title)
      .subscribe({
        next: (data) => {
          this.vehicle = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  deleteVehicle(index: number): void {
    this.vehicleService.delete(index)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/Vehicle']);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }
}
