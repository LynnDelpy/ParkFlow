// Created by Lynn Delpy on 23.08.2024
package model;

public class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }

    public void occupySpot() {
        isOccupied = true;
    }

    public void freeSpot() {
        isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
