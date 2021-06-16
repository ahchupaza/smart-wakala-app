package com.example.smartwakala;

import android.widget.EditText;

public class User {
    public String Contact, Email, Username, Password;

    public User(EditText userContact, EditText userEmail, EditText userUsername, EditText userPassword1){

    }

    public User(String userContact, String userEmail, String userUsername, String userPassword1){
        this.Contact = userContact;
        this.Email = userEmail;
        this.Username = userUsername;
        this.Password = userPassword1;
    }
}
