package com.upgrad.paymentservice.entities;

import javax.persistence.*;

@Entity
public class TransactionDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    @Column(nullable = false)
    private int bookingId;

    @Column
    private String upiId;

    @Column
    private String cardNumber;

    public TransactionDetailsEntity() {
    }

    public TransactionDetailsEntity(int transactionId, PaymentMode paymentMode, int bookingId, String upiId, String cardNumber) {
        this.transactionId = transactionId;
        this.paymentMode = paymentMode;
        this.bookingId = bookingId;
        this.upiId = upiId;
        this.cardNumber = cardNumber;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "TransactionDetailsEntity{" +
                "transactionId=" + transactionId +
                ", paymentMode='" + paymentMode + '\'' +
                ", bookingId=" + bookingId +
                ", upiId='" + upiId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
