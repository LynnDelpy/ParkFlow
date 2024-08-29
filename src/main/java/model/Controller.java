// Created by Lynn Delpy on 28.08.2024
package model;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private final UserInterface ui;
    private final ParkingGarage garage;
    private final PaymentMachine paymentMachine;

    public Controller(UserInterface ui, ParkingGarage garage, PaymentMachine paymentMachine) {
        this.ui = ui;
        this.garage = garage;
        this.paymentMachine = paymentMachine;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String choice = ui.getInput(getMenu());

            switch (choice) {
                case "1":
                    handleEntrance();
                    break;

                case "2":
                    handlePayment();
                    break;

                case "3":
                    handleExit();
                    break;

                case "4":
                    ui.displayAvailableSpots(garage);
                    break;

                case "5":
                    listAllTickets();
                    break;

                case "6":
                    ui.printMessage("Exiting program.");
                    scanner.close();
                    return;

                default:
                    ui.printMessage("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private String getMenu() {
        return "\nChoose an action:\n" +
                "1. Enter garage\n" +
                "2. Pay for parking\n" +
                "3. Exit garage\n" +
                "4. Display available spots\n" +
                "5. List all tickets\n" +
                "6. Exit program\n" +
                "Enter your choice: ";
    }

    void handleEntrance() {
        garage.openEntranceGate();
        Ticket ticket = garage.parkCar();
        garage.closeEntranceGate();

        if (ticket != null) {
            ui.printMessage("Parking ticket issued: " + ticket.getTicketId());
        } else {
            ui.printMessage("Garage is full.");
        }
    }

    void handlePayment() {
        String ticketId = ui.getInput("Enter ticket ID: ");
        Ticket ticket = garage.findTicketById(ticketId);

        if (ticket != null) {
            ui.processPayment(ticket, paymentMachine);
        } else {
            ui.printMessage("Invalid ticket ID.");
        }
    }

    void handleExit() {
        String ticketId = ui.getInput("Enter ticket ID: ");
        Ticket ticket = garage.findTicketById(ticketId);

        if (ticket != null) {
            garage.openExitGate();
            if (garage.exitCar(ticket)) {
                ui.printMessage("Exit successful.");
            } else {
                ui.printMessage("Payment not completed. Please pay before exiting.");
            }
            garage.closeExitGate();
        } else {
            ui.printMessage("Invalid ticket ID.");
        }
    }

    void listAllTickets() {
        List<Ticket> tickets = garage.listAllTickets();
        if (tickets.isEmpty()) {
            ui.printMessage("No tickets issued.");
        } else {
            for (Ticket t : tickets) {
                ui.printMessage(t.toString());
            }
        }
    }
}
