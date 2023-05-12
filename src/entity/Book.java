package entity;

import java.util.Date;

public class Book {
    private int bookId;
    private String customerName;
    private String sinNumber;
    private int roomId;
    private Date bookingDate;
    private int nights;

    private int hotelId;

    public Book(int bookId, String customerName, String sinNumber, int roomId, Date bookingDate, int nights,int hotelId) {
        this.bookId = bookId;
        this.customerName = customerName;
        this.sinNumber = sinNumber;
        this.roomId = roomId;
        this.bookingDate = bookingDate;
        this.nights = nights;
        this.hotelId = hotelId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
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
