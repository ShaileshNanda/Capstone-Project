import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser'; 
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule} from '@angular/common/http';
import { CustomerHelpComponent } from './customer-help/customer-help.component';

const appRoutes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'customer-details',
    component: CustomerDetailsComponent
  },
  {
    path: 'customer-help',
    component: CustomerHelpComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CustomerDetailsComponent,
    HomeComponent,
    FooterComponent,
    CustomerHelpComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
