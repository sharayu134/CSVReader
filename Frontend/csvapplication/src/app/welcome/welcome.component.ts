import { Component, OnInit, ViewChild } from '@angular/core';
import { CsvuploadService } from '../service/csvupload.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor( private csvuploadService: CsvuploadService, private toastr: ToastrService) { }

  file: File;
  message: string;
  @ViewChild('form') form;
  fname: string;
  invalidfileformat: boolean;
  uploaded: boolean;

  ngOnInit(): void {
  }

  handleUpload(){
      this.csvuploadService.UploadCsv(this.file)
            .subscribe (
              data => {
                console.log(data);
              }
            // tslint:disable-next-line:align
            ); this.message = 'File Uploaded successfully';
      this.uploaded = true;
      // this.toastr.info('File uploaded successfully', '');
    }

    selectFile(event) {
      this.file = event.target.files[0];
      console.log( this.file);
      if (!this.validateFile(this.file.name)){
        this.invalidfileformat = true;
        this.toastr.error('Incorrect file format', '');
        this.handleCancel();
      }
    }
    handleCancel(){
      this.file = null;
      this.message = '';
      this.form.nativeElement.reset();
      this.uploaded = false;
    }
    validateFile(name: string) {
      this.fname = name.substring(name.lastIndexOf('.') + 1);
      if (this.fname.toLowerCase() === 'csv') {
          return true;
      }
      else {
          return false;
      }
  }
  }

