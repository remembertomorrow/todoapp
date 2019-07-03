import {StatusViewModel} from "./status-view-model";

export class TaskViewModel {

  task_id: number;
  title:string;
  description:string;
  due_date:Date;
  create_date:Date;
  modify_date:Date;
  priority:string;
  status: StatusViewModel;

}
