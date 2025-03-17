package Model.Implementations;

import Enums.InvoiceType;

public class CashPayment extends PhysicalPayment{
    public CashPayment(float amount, String dniNumber, InvoiceType invoiceType, String shopId) {
        super(amount, dniNumber, invoiceType, shopId);
    }
}
