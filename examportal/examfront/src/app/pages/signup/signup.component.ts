import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  constructor(private userService:UserService,private _snackBar:MatSnackBar){}
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
    //alert('User is required');
    this._snackBar.open('User is Required','OK',{
      duration:3000,verticalPosition:'top'
    });
    return;
  }

  //addUser
  this.userService.addUser(this.user).subscribe(
    (data:any)=>{
      //success
      console.log(data);
      //alert('success');
      Swal.fire('Successfully done!!','User id is '+data.id,'success');
    },
    (error)=>{
      //error
      console.log(error);
      //alert('somthing went to wrong');
      this._snackBar.open('Somting went to wrong','OK',{
        duration:3000,verticalPosition:'top'
      });
    }
  )
}
}
