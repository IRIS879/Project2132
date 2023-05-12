package entity;

import java.util.Date;

public class Rent {
    private int rentId;
    private String customerName;
    private String sinNumber;
    private int roomId;
    private Date rentalDate;
    private int nights;

    private int hotelId;

    public Rent(int rentId, String customerName, String sinNumber, int roomId, Date rentalDate, int nights, int hotelId) {
        this.rentId = rentId;
        this.customerName = customerName;
        this.sinNumber = sinNumber;
        this.roomId = roomId;
        this.rentalDate = rentalDate;
        this.nights = nights;
        this.hotelId = hotelId;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(String sinNumber) {
        this.sinNumber = sinNumber;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getHotelId() {
        return hotelId;
    }
}