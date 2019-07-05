package edu.mum.cs544;

import javax.persistence.Embeddable;

@Embeddable
public class Payment {
    private String paydate;
    private double amount;

    public Payment() {

    }

    public Payment(String paydate, double amount) {
        this.paydate = paydate;
        this.amount = amount;
    }

    public String getPaydate() {
        return paydate;
    }

    public double getAmount() {
        return amount;
    }
}
