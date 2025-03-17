package Repositories.Implementations;

import Model.Implementations.Payment;
import Repositories.Interfaces.Repository;

import java.util.ArrayList;

public class PaymentsRepository implements Repository<Payment> {
    ArrayList<Payment> payments = new ArrayList<>();

    @Override
    public boolean add(Payment payment){
        payments.add(payment);
        return true;
    }

    @Override
    public boolean remove(Payment item) {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
