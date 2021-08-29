package com.upgrad.bookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingInfoDTO {
    private int bookingId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String aadharNumber;
    private int numOfRooms;
    private String roomNumbers;
    private int roomPrice;
    private int transactionId=0;
    private LocalDateTime bookedOn;
}
