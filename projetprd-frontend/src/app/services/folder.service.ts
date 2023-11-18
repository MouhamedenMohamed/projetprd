import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FolderService {
  private apiUrl = 'http://localhost:8080/api'; // Replace with your actual API URL

  constructor(private http: HttpClient) {}

  getFolders(id:number): Observable<any[]> {
    
    return this.http.get<any[]>(`${this.apiUrl}/folders/parent/${id}`);
  }
}
