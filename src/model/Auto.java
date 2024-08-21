package model;

public class Auto {
    private final long einfahrtszeit;
    private final int ticketNummer;
    private boolean bezahlt;

    public Auto(int ticketNummer) {
        this.ticketNummer = ticketNummer;
        this.einfahrtszeit = System.currentTimeMillis();
        this.bezahlt = false;
    }

    public int getTicketNummer() {
        return ticketNummer;
    }

    public long getEinfahrtszeit() {
        return einfahrtszeit;
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
    }
}
