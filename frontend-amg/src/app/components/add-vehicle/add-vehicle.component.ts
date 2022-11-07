import { Component, OnInit } from '@angular/core';
import { Vehicle } from 'src/app/models/vehicle.model';
import { VehicleService } from 'src/app/services/vehicle.service';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {

  vehicle: Vehicle = {
    id: '',
    brand: '',
    model: '',
    model_year: '',
    price: '',
    vin: ''
  };
  submitted = false;
  
  constructor(private vehicleService: VehicleService) { }

  ngOnInit(): void {
  }


  saveVehicle(): void {
    const data = {
      brand: this.vehicle.brand,
      model: this.vehicle.model,
      model_year: this.vehicle.model_year,
      price: this.vehicle.price,
      vin: this.vehicle.vin,
    };

    this.vehicleService.create(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }

  newVehicle(): void {
    this.submitted = false;
    this.vehicle = {
      id: '',
      brand: '',
      model: '',
      model_year: '',
      price: '',
      vin: ''
    };
  }

}
