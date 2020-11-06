import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class CsvuploadService {

  name = 'file';


  constructor(private http: HttpClient) { }

  UploadCsv(file: File){
    const payload = new FormData();
    payload.append('file', file);

    return this.http.post(
      `http://localhost:8080/MarginedRates`
        , payload
        );
  }
}
