import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({ providedIn: 'root' })
export class OnboardingService {
  baseUrl = 'http://localhost:8080/api';
  customer : Customer = new Customer();
  constructor(private http: HttpClient) {}
  
  validateAddress(customer?: Customer):Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/addresses?address=${customer?.address}&stateandcountry=${customer?.stateAndCountry}&pincode=${customer?.pincode}`);
  }

  validateCreditScore(customer?: Customer): Observable<Object> {
    console.log("the service call: "+ customer?.creditScore)
    return this.http.get<Object>(`${this.baseUrl}/creditcheck?username=${customer?.userName}`)
  }

  createUser(customer?: Customer): Observable<Object>{
    console.log("the service call: "+ customer)
    return this.http.post<Object>(`${this.baseUrl}/accounts`, customer);
  }
  getCustomerData(customer?: Customer): Observable<Object>{
    console.log("the service call: "+ customer)
    return this.http.get<Object>(`${this.baseUrl}/getaccount`);
  }
}
