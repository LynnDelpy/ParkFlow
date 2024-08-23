// Created by Lynn Delpy on 23.08.2024
package model;

// Main class to run the simulation
public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        ParkingGarage garage = new ParkingGarage(100, display);

        // Simulate the parking process
        garage.openEntranceGate();
        Ticket ticket = garage.parkCar();
        garage.closeEntranceGate();

        if (ticket != null) {
            UserInterface ui = new UserInterfaceImpl();
            ui.printMessage("Parking ticket issued.");
            ui.getInput("Pay amount?");
            PaymentMachine paymentMachine = new PaymentMachine();
            ui.processPayment(ticket, paymentMachine);

            garage.openExitGate();
            if (garage.exitCar(ticket)) {
                ui.printMessage("Exit successful.");
            } else {
                ui.printMessage("Payment not completed.");
            }
            garage.closeExitGate();
        }
    }
}