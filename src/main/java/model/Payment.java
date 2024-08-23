// Created by Lynn Delpy on 23.08.2024
package model;

import java.util.Date;

public class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public boolean processPayment(Ticket ticket, double amount) {
        if (ticket.isPaid()) {
            System.out.println("Payment has already been made for this ticket.");
            return false;
        }
        double fee = ticket.getFee(new Date()); // Calculate the fee based on current time
        if (amount >= fee) {
            return ticket.pay(amount);
        } else {
            System.out.println("Insufficient payment. The fee is " + fee + " but only " + amount + " was provided.");
            return false;
        }
    }
}

