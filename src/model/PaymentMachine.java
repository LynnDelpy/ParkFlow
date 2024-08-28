// Created by Lynn Delpy on 23.08.2024
package model;

public class PaymentMachine {
    public boolean payTicket(Ticket ticket, double amount) {
        Payment payment = new Payment(amount);
        return payment.processPayment(ticket, amount);
    }
}