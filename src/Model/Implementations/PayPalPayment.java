package Model.Implementations;

import Enums.InvoiceType;

public class PayPalPayment extends ElectronicPayment {
    String emailAddress;

    public PayPalPayment(float amount, String dniNumber, InvoiceType invoiceType, String website, String emailAddress) {
        super(amount, dniNumber, invoiceType, website);
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
