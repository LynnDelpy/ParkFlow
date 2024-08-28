// Created by Lynn Delpy on 23.08.2024
package model;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private Date issueTime;
    private boolean paid;

    public Ticket(String ticketId) {
        this.ticketId = ticketId;
        this.issueTime = new Date();
        this.paid = false;
    }

    public double getFee(Date currentTime) {
        // Missing logic to calculate fee
        return 10.0; // Placeholder fee
    }

    public boolean pay(double amount) {
        // Missing payment logic
        this.paid = true;
        return true;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getTicketId() {
        return ticketId;
    }
}

