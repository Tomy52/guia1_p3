package Model.Implementations;

import Enums.InvoiceType;

public class PhysicalPayment extends Payment{
    String shopId;

    public PhysicalPayment(float amount, String dniNumber, InvoiceType invoiceType, String shopId) {
        super(amount, dniNumber, invoiceType);
        this.shopId = shopId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}
