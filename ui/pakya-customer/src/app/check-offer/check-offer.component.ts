import { Component, OnInit } from '@angular/core';
import { PakyaServiceService } from '../pakya-service.service';

@Component({
  selector: 'app-check-offer',
  templateUrl: './check-offer.component.html',
  styleUrls: ['./check-offer.component.scss']
})
export class CheckOfferComponent implements OnInit {
  someData:any;

  constructor(private pakysService: PakyaServiceService) { }
  
  ngOnInit(): void {
     this.pakysService.readFromServer1().subscribe(response =>{
        this.someData = response;
    });
  }

}
