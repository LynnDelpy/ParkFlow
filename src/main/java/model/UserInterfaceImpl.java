// Created by Lynn Delpy on 23.08.2024
package model;

import java.util.Date;
import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void displayAvailableSpots(ParkingGarage parkingGarage) {
        System.out.println("Available spots: " + parkingGarage.getAvailableSpots());
    }

    @Override
    public void processPayment(Ticket ticket, PaymentMachine paymentMachine) {
        double fee = ticket.getFee(new Date());
        printMessage("The total fee is: $" + fee);
        String input = getInput("Pay amount: ");
        double amount = Double.parseDouble(input);
        boolean status = paymentMachine.payTicket(ticket, amount);
        if (status) {
            printMessage("Payment processed successfully.");
        } else {
            printMessage("Payment failed. Please try again.");
        }
    }
}
