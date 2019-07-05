import { Component, OnInit } from '@angular/core';
import {ApiService} from "../shared/api.service";
import {TaskViewModel} from "../shared/model/task-view-model";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks: TaskViewModel[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.getAllTasks();
  }

  public getAllTasks(){
    this.apiService.getAllTasks().subscribe(
      res => {
        this.tasks = res;

      },
      error1 => {
        alert(environment.generalError)
      }
    );
  }
}
