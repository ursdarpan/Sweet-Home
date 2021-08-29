package com.upgrad.paymentservice.services;

import com.upgrad.paymentservice.entities.TransactionDetailsEntity;

import java.util.List;

public interface PaymentService {
    public TransactionDetailsEntity acceptPaymentDetails(TransactionDetailsEntity transactionDetailsEntity);

    public TransactionDetailsEntity getPaymentDetailsById(int id);

    public List<TransactionDetailsEntity> getAllTransactions();

    public TransactionDetailsEntity updatePaymentTransaction(int id,TransactionDetailsEntity transactionDetailsEntity);

    public boolean deletePaymentTransaction(int id);
}
