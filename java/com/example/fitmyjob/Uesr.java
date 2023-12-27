package com.example.fitmyjob;

public class Uesr {

    String company_name;
    String description;

    String date;


    String location;

    String salary;
    String test;



    public String getCompany_name() {
        return company_name;
    }


    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }



    public String getLocation() {
        return location;
    }


    public String getSalary() {
        return salary;
    }
    public String getTest() {
        return test;
    }








    public Uesr(String company_name,  String date,String description, String location ,String salary, String test){
        this.company_name=company_name;

        this.description = description;
        this.date = date;

        this.location=location;
        this.salary=salary;
        this.test=test;





    }

    public Uesr(){


    }
}