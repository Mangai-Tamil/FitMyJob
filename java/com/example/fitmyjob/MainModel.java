package com.example.fitmyjob;

public class MainModel {

    String company_name;


    String contactno;

    String date;
    String description;
    String id;
    String location;

    String salary;
    MainModel()
    {

    }
    public MainModel(String company_name, String contactno, String date, String description, String id, String location, String salary) {
        this.company_name = company_name;
        this.contactno = contactno;
        this.date = date;
        this.description = description;
        this.id = id;
        this.location = location;
        this.salary = salary;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getContact_no() {
        return contactno;
    }

    public void setContactno(String contact_no) {
        this.contactno = contactno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
