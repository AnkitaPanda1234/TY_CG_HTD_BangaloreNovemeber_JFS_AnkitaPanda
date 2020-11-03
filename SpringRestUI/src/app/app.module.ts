import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ClientComponent } from './client/client.component';
import { SchedulerComponent } from './scheduler/scheduler.component';
import { AdminComponent } from './admin/admin.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CustomerComponent } from './customer/customer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddProductComponent } from './add-product/add-product.component';
import { DeleteUpdateProductComponent } from './delete-update-product/delete-update-product.component';
import { AddLandComponent } from './add-land/add-land.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { AddClientComponent } from './add-client/add-client.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AddSchedulerComponent } from './add-scheduler/add-scheduler.component';
import { LoginclientComponent } from './loginclient/loginclient.component';
import { LoginschedulerComponent } from './loginscheduler/loginscheduler.component';
import { AddContractComponent } from './add-contract/add-contract.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { AddScheduleComponent } from './add-schedule/add-schedule.component';
import { ProductsComponent } from './products/products.component';
import { LandsComponent } from './lands/lands.component';
import { DeleteUpdateLandComponent } from './delete-update-land/delete-update-land.component';
import { DeleteUpdateCustomerComponent } from './delete-update-customer/delete-update-customer.component';
import { FilterProductsPipe } from './filter-products.pipe';
import { ContractsComponent } from './contracts/contracts.component';
import { DeleteUpdateContractComponent } from './delete-update-contract/delete-update-contract.component';
import { SchedulesComponent } from './schedules/schedules.component';
import { DeleteUpdateScheduleComponent } from './delete-update-schedule/delete-update-schedule.component';
import { FilterLandsPipe } from './filter-lands.pipe';
import { FilterContractsPipe } from './filter-contracts.pipe';
import { FilterSchedulesPipe } from './filter-schedules.pipe';
import { FilterCustomerPipe } from './filter-customer.pipe';
import { ClientAccountComponent } from './client-account/client-account.component';
import { DeleteUpdateClientComponent } from './delete-update-client/delete-update-client.component';
import { FilterClientPipe } from './filter-client.pipe';
import { SchedulerAccountComponent } from './scheduler-account/scheduler-account.component';
import { DeleteUpdateSchedulerComponent } from './delete-update-scheduler/delete-update-scheduler.component';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ClientComponent,
    SchedulerComponent,
    AdminComponent,
    HomeComponent,
    CustomerComponent,
    AddProductComponent,
    DeleteUpdateProductComponent,
    AddLandComponent,
    LoginComponent,
    LogoutComponent,
    AboutUsComponent,
    AddClientComponent,
    PageNotFoundComponent,
    AddSchedulerComponent,
    LoginclientComponent,
    LoginschedulerComponent,
    AddContractComponent,
    AddCustomerComponent,
    AddScheduleComponent,
    ProductsComponent,
    LandsComponent,
    DeleteUpdateLandComponent,
    DeleteUpdateCustomerComponent,
    FilterProductsPipe,
    ContractsComponent,
    DeleteUpdateContractComponent,
    SchedulesComponent,
    DeleteUpdateScheduleComponent,
    FilterLandsPipe,
    FilterContractsPipe,
    FilterSchedulesPipe,
    FilterCustomerPipe,
    ClientAccountComponent,
    DeleteUpdateClientComponent,
    FilterClientPipe,
    SchedulerAccountComponent,
    DeleteUpdateSchedulerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'admin' , component: AdminComponent},
      {path: 'client', component: ClientComponent},
      {path: 'client-account', component: ClientAccountComponent},
      {path: 'scheduler', component: SchedulerComponent},
      {path: 'loginclient', component: LoginclientComponent},
      {path: 'loginscheduler', component: LoginschedulerComponent},
      {path: 'add-product', component: AddProductComponent},
      {path: 'scheduler-account', component: SchedulerAccountComponent},
      {path: 'add-contract', component: AddContractComponent},
      {path: 'add-customer', component: AddCustomerComponent},
      {path: 'login', component: LoginComponent},
      {path: 'add-client', component: AddClientComponent},
      {path: 'add-scheduler', component: AddSchedulerComponent},
      {path: 'add-schedule', component: AddScheduleComponent},
      {path: 'add-land', component: AddLandComponent},
      {path: 'products', component: ProductsComponent},
      {path: 'delete-update-product', component: DeleteUpdateProductComponent},
      {path: 'schedules', component: SchedulesComponent},
      {path: 'delete-update-schedule', component: DeleteUpdateScheduleComponent},
      {path: 'contracts', component: ContractsComponent},
      {path: 'delete-update-contract', component: DeleteUpdateContractComponent},
      {path: 'delete-update-client', component: DeleteUpdateClientComponent},
      {path: 'lands', component: LandsComponent},
      {path: 'delete-update-land', component: DeleteUpdateLandComponent},
      {path: 'customer', component: CustomerComponent},
      {path: 'delete-update-customer', component: DeleteUpdateCustomerComponent},
      {path: 'logout', component: LogoutComponent},
       {path: 'about-us', component: AboutUsComponent},
      {path: '**', component: PageNotFoundComponent},
    ]),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
