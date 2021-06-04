package com.example.smartwakala;

import android.widget.EditText;

public class User {
    public String userEmail, userUsername, userPassword1;
    public  int userContact;

    public User(EditText userContact, EditText userEmail, EditText userUsername, EditText userPassword1){

    }

    public User(int userContact, String userEmail, String userUsername, String userPassword1, String userPassword2){
        this.userContact = userContact;
        this.userEmail = userEmail;
        this.userUsername = userUsername;
        this.userPassword1 = userPassword1;
    }
}
