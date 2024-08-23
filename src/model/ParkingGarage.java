// Created by Lynn Delpy on 23.08.2024
package model;

import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {
    private int totalSpots;
    private int availableSpots;
    private Display display;
    private EntranceGate entranceGate;
    private ExitGate exitGate;
    private List<ParkingSpot> parkingSpots;

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
                spot.occupySpot();
                availableSpots--;
                display.updateAvailableSpots(availableSpots);
                return new Ticket("T" + spot.getSpotNumber());
            }
        }
        return null; // No available spot
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