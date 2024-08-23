// Created by Lynn Delpy on 23.08.2024
package model;

public class UserInterfaceImpl implements UserInterface {
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        // Mock input
        return "10"; // Placeholder amount
    }

    @Override
    public void displayAvailableSpots(ParkingGarage parkingGarage) {
        System.out.println("Available spots: " + parkingGarage.getAvailableSpots());
    }

    @Override
    public void processPayment(Ticket ticket, PaymentMachine paymentMachine) {
        String input = getInput("Pay amount?");
        double amount = Double.parseDouble(input);
        boolean status = paymentMachine.payTicket(ticket, amount);
        if (status) {
            printMessage("Payment successful.");
        } else {
            printMessage("Payment failed.");
        }
    }
}