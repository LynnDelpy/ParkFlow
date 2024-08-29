// Created by Lynn Delpy on 23.08.2024
package model;

public class ParkingSpot {
    private final int spotNumber;
    private boolean isOccupied;
    private Ticket ticket; // Add this field

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
        this.ticket = null;
    }

    public void occupySpot(Ticket ticket) {
        isOccupied = true;
        this.ticket = ticket;
    }

    public void freeSpot() {
        isOccupied = false;
        this.ticket = null;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
