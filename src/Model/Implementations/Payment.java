package Model.Implementations;

import Enums.InvoiceType;

public abstract class Payment {
    float amount;
    int transactionId;
    int transactionCounter = 0;
    String dniNumber;
    InvoiceType invoiceType;

    public Payment(float amount, String dniNumber, InvoiceType invoiceType) {
        this.amount = amount;
        transactionCounter++;
        transactionId = transactionCounter;
        this.dniNumber = dniNumber;
        this.invoiceType = invoiceType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getDniNumber() {
        return dniNumber;
    }

    public void setDniNumber(String dniNumber) {
        this.dniNumber = dniNumber;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }
}
