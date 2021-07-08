package com.example.smartwakala.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Wakala extends RealmObject {

    @PrimaryKey
    @Required
    private String ID_No;

    private String FirstName, MiddleName, LastName, DoB, Licence_No, SIM_No, Code_No, TIN_No, BusinessRegion;

    private long Balance, Kamisheni;

    public Wakala(String ID_No, String firstName, String middleName, String lastName, String doB, String licence_No, String SIM_No, String code_No, String TIN_No, String businessRegion, long balance, long kamisheni) {
        this.ID_No = ID_No;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        DoB = doB;
        Licence_No = licence_No;
        this.SIM_No = SIM_No;
        Code_No = code_No;
        this.TIN_No = TIN_No;
        BusinessRegion = businessRegion;
        Balance = balance;
        Kamisheni = kamisheni;
    }

    public Wakala() {
    }

    public String getID_No() {
        return ID_No;
    }

    public void setID_No(String ID_No) {
        this.ID_No = ID_No;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String getLicence_No() {
        return Licence_No;
    }

    public void setLicence_No(String licence_No) {
        Licence_No = licence_No;
    }

    public String getSIM_No() {
        return SIM_No;
    }

    public void setSIM_No(String SIM_No) {
        this.SIM_No = SIM_No;
    }

    public String getCode_No() {
        return Code_No;
    }

    public void setCode_No(String code_No) {
        Code_No = code_No;
    }

    public String getTIN_No() {
        return TIN_No;
    }

    public void setTIN_No(String TIN_No) {
        this.TIN_No = TIN_No;
    }

    public String getBusinessRegion() {
        return BusinessRegion;
    }

    public void setBusinessRegion(String businessRegion) {
        BusinessRegion = businessRegion;
    }

    public long getBalance() {
        return Balance;
    }

    public void setBalance(long balance) {
        Balance = balance;
    }

    public long getKamisheni() {
        return Kamisheni;
    }

    public void setKamisheni(long kamisheni) {
        Kamisheni = kamisheni;
    }
}