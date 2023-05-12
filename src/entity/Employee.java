package entity;
public class Employee {
    private String name;
    private String SIN;
    private int hotel_id;
    private String password;
    private String address;

    public Employee(String name, String SIN, int hotel_id, String password, String address) {
        this.name = name;
        this.SIN = SIN;
        this.hotel_id = hotel_id;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSIN() {
        return SIN;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}