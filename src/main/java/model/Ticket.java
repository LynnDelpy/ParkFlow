package model;

import java.util.Date;

public class Ticket {
    private final String ticketId;
    Date issueTime;
    private boolean paid;

    public Ticket(String ticketId) {
        this.ticketId = ticketId;
        this.issueTime = new Date();
        this.paid = false;
    }

    public double getFee(Date currentTime) {
        long duration = currentTime.getTime() - issueTime.getTime();
        long hours = (duration / (1000 * 60 * 60)) + 1; // Always round up to the next hour
        return hours * 5.0;
    }

    public boolean pay(double amount) {
        if (paid) {
            System.out.println("This ticket has already been paid.");
            return false;
        }
        this.paid = true;
        return true;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + ", Issued: " + issueTime + ", Paid: " + paid;
    }
}
