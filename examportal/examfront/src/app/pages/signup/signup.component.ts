import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  constructor(private userService:UserService){}
  public user={
    username:'',
    password:'',
    firstName:'',
    lastName:'',
    email:'',
    phone:''
  };
ngOnInit():void{}

formSubmit(){
  console.log(this.user);
  if(this.user.username=='' || this.user.username==null){
    alert('User is required');
    return;
  }

  //addUser
  this.userService.addUser(this.user).subscribe(
    (date)=>{
      //success
      alert('success');
    },
    (error)=>{
      //error
      console.log(error);
      alert('somthing went to wrong');
    }
  )
}
}
