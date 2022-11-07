import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer.model';

const baseUrl = 'http://localhost:8083/api/';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(baseUrl+"getCustomerDetails");
  }

  get(id: any): Observable<Customer> {
    return this.http.get<Customer>(`${baseUrl+"getCustomerDetailsById"}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl+"customer", data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl+"updateCustomerDetailsById"}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl+"deleteCustomerDetailsById"}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByTitle(title: any): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${baseUrl}?title=${title}`);
  }
}
