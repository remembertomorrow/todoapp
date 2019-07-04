import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TaskViewModel} from "./model/task-view-model";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private BASE_URL = "http://localhost:8080/";
  private ALL_TASKS_URL = `${this.BASE_URL}\\tasks`;

  constructor(private http: HttpClient) { }

  getAllTasks() : Observable<TaskViewModel[]>{
    return this.http.get<TaskViewModel[]>(this.ALL_TASKS_URL);
  }
}
