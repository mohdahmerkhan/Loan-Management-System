import { Role } from "./role";

export class User
{
    userID : number;
    password : string;
    email : string;
    name : string;
    dateOfBirth : Date;
    phoneNo : string;
    isActive : boolean;
    role : Role;
}
