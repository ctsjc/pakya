import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PakyaServiceService {

  constructor(private http: HttpClient) { }

  /**
   * readFromServer1
   * 
   */
  public readFromServer1() {
    return this.http.get('https://jsonplaceholder.typicode.com/todos/1');    
  }
}
