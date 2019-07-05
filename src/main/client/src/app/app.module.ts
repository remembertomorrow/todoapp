import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TaskComponent } from './task/task.component';
import { TaskListComponent } from './task-list/task-list.component';
import {Router, RouterModule, Routes, Event, NavigationStart, NavigationEnd} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {MatGridListModule} from '@angular/material/grid-list';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';



const appRoutes

  :Routes = [
  {
    path: "tasks",
    component: TaskListComponent
  },
  {
    path: "",
    component: TaskListComponent,
    pathMatch: "full"
  },
  {
    path: "task/:taskId",
    component: TaskComponent,
  }
];


@NgModule({
  declarations: [
    AppComponent,
    TaskComponent,
    TaskListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    BrowserAnimationsModule,
    MatGridListModule,
    MatButtonModule,
    MatCheckboxModule,
    MatListModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
