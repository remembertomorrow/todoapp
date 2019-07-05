import {StatusViewModel} from "./status-view-model";

export class TaskViewModel {

  taskId: number;
  title: string;
  description:string;
  dueDate:Date;
  createDate:Date;
  modifyDate:Date;
  priority:string;
  status: StatusViewModel;

}
