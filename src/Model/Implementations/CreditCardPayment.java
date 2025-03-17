package Model.Implementations;

import Enums.InvoiceType;

import java.time.LocalDate;

public class CreditCardPayment extends PhysicalPayment {
    String cardNumber;
    String cvv;
    String holder;
    LocalDate expirationDate;

    public CreditCardPayment(float amount, String dniNumber, InvoiceType invoiceType, String shopId, String cardNumber, String cvv, String holder, LocalDate expirationDate) {
        super(amount, dniNumber, invoiceType, shopId);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.holder = holder;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
