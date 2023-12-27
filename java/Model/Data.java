package Model;

public class Data {

    String company_name;
    String description;
    String location;

    String salary;
    String test;




    String id;
    String date;

    public Data(){


    }

    public Data(String company_name,String description, String location, String salary,String test,  String id, String date) {
        this.company_name = company_name;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.test = test;


        this.id = id;
        this.date = date;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }






    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
