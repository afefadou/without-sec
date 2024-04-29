import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostesService {
  private apiUrl = 'http://localhost:3000/postes';

  constructor(private http: HttpClient) { }

  getAllPostes(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getPosteById(id: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  createPoste(poste: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, poste);
  }

  updatePoste(id: string, updatedPoste: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, updatedPoste);
  }

  deletePoste(id: string): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
