package com.upgrad.bookingservice.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class BookingInfoEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

@Column
    private LocalDate fromDate;

@Column
    private LocalDate toDate;

@Column
    private String aadharNumber;

@Column
    private int numOfRooms;

@Column
    private String roomNumbers;

@Column
    private int roomPrice;

@Column
    private int transactionId=0;

@Column
    private LocalDateTime bookedOn;

    public BookingInfoEntity() {
    }

    public BookingInfoEntity(int bookingId, LocalDate fromDate, LocalDate toDate, String aadharNumber, int numOfRooms, String roomNumbers, int roomPrice, int transactionId, LocalDateTime bookedOn) {
        this.bookingId = bookingId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.aadharNumber = aadharNumber;
        this.numOfRooms = numOfRooms;
        this.roomNumbers = roomNumbers;
        this.roomPrice = roomPrice;
        this.transactionId = transactionId;
        this.bookedOn = bookedOn;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(LocalDateTime bookedOn) {
        this.bookedOn = bookedOn;
    }

    @Override
    public String toString() {
        return "BookingInfoEntity{" +
                "bookingId=" + bookingId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", numOfRooms=" + numOfRooms +
                ", roomNumbers='" + roomNumbers + '\'' +
                ", roomPrice=" + roomPrice +
                ", transactionId=" + transactionId +
                ", bookedOn=" + bookedOn +
                '}';
    }
}
