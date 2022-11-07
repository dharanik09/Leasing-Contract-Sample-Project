import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Vehicle } from 'src/app/models/vehicle.model';
import { VehicleService } from 'src/app/services/vehicle.service';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css']
})
export class VehicleDetailsComponent implements OnInit {
  
  @Input() viewMode = false;

  @Input() currentVehicle: Vehicle = {
    id: '',
    brand: '',
    model: '',
    model_year: '',
    price: '',
    vin: ''
  };

  
  message = '';

  constructor(
    private vehicleService: VehicleService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
     if (!this.viewMode) {
       this.message = '';
       this.getvehicle(this.route.snapshot.params["id"]);
     }
  }

  getvehicle(id: string): void {
    this.vehicleService.get(id)
      .subscribe({
        next: (data) => {
          this.currentVehicle = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  updatePublished(status: boolean): void {
    const data = {
      id: this.currentVehicle.id,
      brand: this.currentVehicle.brand,
      model: this.currentVehicle.model,
      model_year: this.currentVehicle.model_year,
      price: this.currentVehicle.price,
      vin: this.currentVehicle.vin
    };


    this.message = '';

    this.vehicleService.update(this.currentVehicle.id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.currentVehicle.brand = this.currentVehicle.brand,
          this.currentVehicle.model= this.currentVehicle.model,
          this.currentVehicle.model_year= this.currentVehicle.model_year,
          this.currentVehicle.price= this.currentVehicle.price,
          this.currentVehicle.vin= this.currentVehicle.vin
          this.message = res.message ? res.message : 'The status was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  updateVehicle(): void {
    this.message = '';

    this.vehicleService.update(this.currentVehicle.id, this.currentVehicle)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This Vehicle was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  deleteVehicle(): void {
    this.vehicleService.delete(this.currentVehicle.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/Vehicle']);
        },
        error: (e) => console.error(e)
      });
  }

}
