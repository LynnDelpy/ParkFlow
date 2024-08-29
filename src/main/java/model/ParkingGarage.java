// Created by Lynn Delpy on 23.08.2024
package model;

import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {
    private final int totalSpots;
    private int availableSpots;
    private final Display display;
    private final EntranceGate entranceGate;
    private final ExitGate exitGate;
    private final List<ParkingSpot> parkingSpots;

    public ParkingGarage(int totalSpots, Display display) {
        this.totalSpots = totalSpots;
        this.availableSpots = totalSpots;
        this.display = display;
        this.entranceGate = new EntranceGate();
        this.exitGate = new ExitGate();
        this.parkingSpots = new ArrayList<>();
        for (int i = 0; i < totalSpots; i++) {
            parkingSpots.add(new ParkingSpot(i + 1));
        }
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public Ticket parkCar() {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable()) {
                Ticket ticket = new Ticket("T" + spot.getSpotNumber());
                spot.occupySpot(ticket);  // Store the ticket in the spot
                availableSpots--;
                display.updateAvailableSpots(availableSpots);
                return ticket;
            }
        }
        return null; // No available spot
    }
    public List<Ticket> listAllTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isAvailable() && spot.getTicket() != null) {
                tickets.add(spot.getTicket());
            }
        }
        return tickets;
    }


    public boolean exitCar(Ticket ticket) {
        if (ticket.isPaid()) {
            for (ParkingSpot spot : parkingSpots) {
                if (spot.getSpotNumber() == Integer.parseInt(ticket.getTicketId().substring(1))) {
                    spot.freeSpot();
                    availableSpots++;
                    display.updateAvailableSpots(availableSpots);
                    return true;
                }
            }
        }
        return false;
    }

    public Ticket findTicketById(String ticketId) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isAvailable() && spot.getTicket() != null && spot.getTicket().getTicketId().equals(ticketId)) {
                return spot.getTicket();
            }
        }
        return null;
    }


    public void openEntranceGate() {
        entranceGate.openGate();
    }

    public void closeEntranceGate() {
        entranceGate.closeGate();
    }

    public void openExitGate() {
        exitGate.openGate();
    }

    public void closeExitGate() {
        exitGate.closeGate();
    }
}