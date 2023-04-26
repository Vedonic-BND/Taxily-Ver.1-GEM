package com.example.taxilyver1;

public class User {

    public String newname;
    public String newemail;
    public String newpass;
    public String newnum;

    public User(){

    }

    public User(String newname, String newemail, String newpass, String newnum){
        this.newname = newname;
        this.newemail = newemail;
        this.newpass = newpass;
        this.newnum= newnum;

    }

    public String getNewname(){
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname;
    }

    public String getNewemail(){
        return newemail;
    }

    public void setNewemail(String newemail) {
        this.newemail = newemail;
    }

    public String getNewpass(){
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getNewnum(){
        return newnum;
    }

    public void setNewnum(String newnum) {
        this.newnum = newnum;
    }

}
