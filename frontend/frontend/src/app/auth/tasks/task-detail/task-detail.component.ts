import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.scss'],
})
export class TaskDetailComponent implements OnInit {
  taskId!: number;
  task: any;

  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService
  ) {}

  ngOnInit(): void {
    this.taskId = Number(this.route.snapshot.paramMap.get('id'));
    if (this.taskId) {
      this.loadTask();
    }
  }

  loadTask(): void {
    this.taskService.getTaskById(this.taskId).subscribe({
      next: (data: any) => (this.task = data),
      error: (err: any) => console.error('Błąd przy pobieraniu zadania:', err),
    });
  }
}
