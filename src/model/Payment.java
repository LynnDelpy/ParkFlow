// Created by Lynn Delpy on 23.08.2024
package model;

public class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public boolean processPayment(Ticket ticket, double amount) {
        // Payment processing logic will be added later
        return ticket.pay(amount);
    }
}