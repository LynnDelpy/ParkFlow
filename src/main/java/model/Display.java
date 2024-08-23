// Created by Lynn Delpy on 23.08.2024
package model;

public class Display {
    private int availableSpots;

    public void updateAvailableSpots(int spots) {
        this.availableSpots = spots;
        System.out.println("Available spots updated: " + availableSpots);
    }

    public int getAvailableSpots() {
        return availableSpots;
    }
}