package model;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketNummer;
    private LocalDateTime ausstellungsdatum;
    private int parkplatzNummer;

    public Ticket(int parkplatzNummer) {
        this.ticketNummer = generateUniqueTicketNumber();
        this.ausstellungsdatum = LocalDateTime.now();
        this.parkplatzNummer = parkplatzNummer;
    }

    private String generateUniqueTicketNumber() {
        return "TK" + System.currentTimeMillis();
    }

    public String getTicketNummer() {
        return ticketNummer;
    }

    public LocalDateTime getAusstellungsdatum() {
        return ausstellungsdatum;
    }

    public int getParkplatzNummer() {
        return parkplatzNummer;
    }
}
