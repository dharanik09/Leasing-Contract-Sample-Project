import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicle } from '../models/vehicle.model';

const baseUrl = 'http://localhost:8083/api/';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(baseUrl+"getVehicleDetails");
  }

  get(id: any): Observable<Vehicle> {
    return this.http.get<Vehicle>(`${baseUrl+"getVehicleDetailsById"}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl+"vehicle", data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl+"updateVehicleDetailsById"}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl+"deleteVehicleDetailsById"}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByTitle(title: any): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(`${baseUrl}?title=${title}`);
  }}
