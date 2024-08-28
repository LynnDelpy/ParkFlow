package model;

// Interface for UserInterface
public interface UserInterface {
    void printMessage(String message);
    String getInput(String prompt);
    void displayAvailableSpots(ParkingGarage parkingGarage);
    void processPayment(Ticket ticket, PaymentMachine paymentMachine);
}
