import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import * as uuid from 'uuid';
import { Customer } from '../customer';
import { OnboardingService } from '../onboarding.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css'],
})
export class CustomerDetailsComponent {
  myId = uuid.v4();
  dummy: any;
  customer: Customer = new Customer();
  addressErrors: any = null;
  creditError: any = null;
  errors: any= null;
  submitted = false;
  dataSubmitted = false;
  userData: any;

  constructor(private onboardingService: OnboardingService) {}

  onSubmit() {
    this.submitted= false;
    console.log(this.customer);
    this.validateAddress();
    this.submitted= true
  }
  validateCreditScore() {
    this.onboardingService.validateCreditScore(this.customer).subscribe(
      (data) => {
        this.dummy = data;
        this.createNewCustomer();
        this.creditError = null;
      },
      (error) => {
        console.log('error in credit score check', error);
        this.creditError = error;
        this.dataSubmitted = false;
      }
    );
  }
  createNewCustomer() {
    this.onboardingService.createUser(this.customer).subscribe(
      (data) => {
        this.dummy = data;
        this.getData();
        this.errors = null;
      },
      (error) => {
        console.log('error in customer creation', error);
        this.errors = error;
        this.dataSubmitted = false;
      }
    );
  }
  validateAddress() {
    this.onboardingService.validateAddress(this.customer).subscribe(
      (data) => {
        this.dummy = data;
        this.validateCreditScore();
        this.addressErrors = null;
      },
      (error) => {
        console.log('error in address', error);
        this.addressErrors = error;
        this.dataSubmitted = false;
      }
    );
  }
  getData() {
    this.onboardingService.getCustomerData(this.customer).subscribe(
      (data) => {
        this.userData = data;
        console.log('Final get', data)
        this.errors = null;
        this.dataSubmitted=true;
        this.setData(this.userData);
      },
      (error) => {
        console.log('error in getting data', error);
        this.errors = error;
        this.dataSubmitted = false;
      }
    );
  }
  setData(data: { Account: { userName: string | undefined; email: string | undefined; address: string | undefined; stateAndCountry: string | undefined; pincode: number | undefined; number: number | undefined; gender: string | undefined; accountType: string | undefined; }; }){
    this.customer.userName = data.Account.userName;
    this.customer.email = data.Account.email;
    this.customer.address = data.Account.address;
    this.customer.stateAndCountry = data.Account.stateAndCountry;
    this.customer.pincode = data.Account.pincode;
    this.customer.number = data.Account.number;
    this.customer.gender = data.Account.gender;
    this.customer.accountType = data.Account.accountType;
  }
}
