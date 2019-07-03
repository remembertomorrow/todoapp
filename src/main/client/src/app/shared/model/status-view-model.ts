import {TaskViewModel} from "./task-view-model";

export class StatusViewModel {

  status_id: number;
  status: string;
  startDate: Date;
  finishDate: Date;
  tasks: TaskViewModel[];

}
