import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer.model';
import { Leasing } from '../models/leasing.model';

const baseUrl = 'http://localhost:8083/api/';

@Injectable({
  providedIn: 'root'
})
export class LeasingService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Leasing[]> {
    return this.http.get<Leasing[]>(baseUrl+"getLeasingContratDetails");
  }

  getAllCustomerDetails(): Observable<Leasing[]> {
    return this.http.get<Leasing[]>(baseUrl+"getCustomerDetails");
  }

  getAllVehicleDetails(): Observable<Leasing[]> {
    return this.http.get<Leasing[]>(baseUrl+"getVehicleDetails");
  }

  getCustomer(id: any): Observable<Customer> {
    return this.http.get<Customer>(`${baseUrl+"getCustomerDetailsById"}/${id}`);
  }


  get(id: any): Observable<Leasing> {
    return this.http.get<Leasing>(`${baseUrl+"getLeasingDetailsById"}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl+"leasingcontract", data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl+"updateLeasingDetailsById"}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl+"deleteLeasingDetailsById"}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByTitle(title: any): Observable<Leasing[]> {
    return this.http.get<Leasing[]>(`${baseUrl}?title=${title}`);
  }}
