package Model.Implementations;

import Enums.InvoiceType;

public class ElectronicPayment extends Payment{
    private String website;

    public ElectronicPayment(float amount, String dniNumber, InvoiceType invoiceType, String website) {
        super(amount, dniNumber, invoiceType);
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nsitio web de referencia: " + website;
    }
}
