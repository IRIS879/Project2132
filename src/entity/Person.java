package entity;

import java.util.Date;

public class Person {

    private String name;
    private String pwd;

    private String address;
    private String sin;
    private Date registrationDate;

    public Person(String name,  String address, String sin, Date registrationDate,String pwd){
        this.name=name;
        this.pwd=pwd;
        this.address = address;
        this.sin = sin;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return this.pwd;
    }

    public String getAddress() {
        return address;
    }

    public String getSin() {
        return sin;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
