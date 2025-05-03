import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getTasks(): Observable<any> {
    return this.http.get(`${this.apiUrl}/api/tasks`);
  }

  getTasksByCategory(categoryId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/api/tasks/category/${categoryId}`);
  }

  createTask(taskData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/api/tasks`, taskData);
  }

  updateTask(taskId: number, taskData: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/api/tasks/${taskId}`, taskData);
  }

  deleteTask(taskId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/api/tasks/${taskId}`);
  }
}
