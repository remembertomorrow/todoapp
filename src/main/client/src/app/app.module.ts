import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TaskComponent } from './task/task.component';
import { TaskListComponent } from './task-list/task-list.component';
import {Router, RouterModule, Routes, Event, NavigationStart, NavigationEnd} from "@angular/router";

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
  }
  // ,
  // {
  //   path: "**",
  //   component: NotFoundComponent
  // }
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
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
