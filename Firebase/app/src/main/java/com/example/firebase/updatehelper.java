package com.example.firebase;

public class updatehelper {
    String Name,Number,Dept;

    public updatehelper(){

    }

    public updatehelper(String name, String number, String dept){
        Name = name;
        Number = number;
        Dept = dept;
    }

    public String getName() {
        return Name;
    }

    public String getNumber() {
        return Number;
    }

    public String getDept() {
        return Dept;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public void setDept(String dept) {
        Dept = dept;
    }
}

