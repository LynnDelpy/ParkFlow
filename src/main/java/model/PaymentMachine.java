// Created by Lynn Delpy on 23.08.2024
package model;

import java.util.Date;

public class PaymentMachine {
    public boolean payTicket(Ticket ticket, double amount) {
        double fee = ticket.getFee(new Date());
        if (amount >= fee) {
            boolean success = ticket.pay(amount);
            if (success) {
                double change = amount - fee;
                if (change > 0) {
                    System.out.println("Payment successful. Your change is: $" + change);
                } else {
                    System.out.println("Payment successful. No change needed.");
                }
                return true;
            }
        } else {
            System.out.println("Insufficient payment. The required fee is: $" + fee);
        }
        return false;
    }
}

