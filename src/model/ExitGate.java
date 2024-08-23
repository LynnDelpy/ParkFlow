// Created by Lynn Delpy on 23.08.2024
package model;

public class ExitGate extends Gate {
    @Override
    public void openGate() {
        System.out.println("Exit gate opening.");
    }

    @Override
    public void closeGate() {
        System.out.println("Exit gate closing.");
    }
}