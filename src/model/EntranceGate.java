package model;

// EntranceGate class extending Gate
public class EntranceGate extends Gate {
    @Override
    public void openGate() {
        System.out.println("Entrance gate opening.");
    }

    @Override
    public void closeGate() {
        System.out.println("Entrance gate closing.");
    }
}