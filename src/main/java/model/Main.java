// Created by Lynn Delpy on 23.08.2024
package model;

// Main class to run the simulation
public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterfaceImpl();
        ParkingGarage garage = new ParkingGarage(100, new Display());
        PaymentMachine paymentMachine = new PaymentMachine();

        Controller controller = new Controller(ui, garage, paymentMachine);
        controller.run();
    }
}