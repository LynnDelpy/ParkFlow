// Created by Lynn Delpy on 28.08.2024

package model;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ControllerTest {
    private UserInterface ui;
    private ParkingGarage garage;
    private PaymentMachine paymentMachine;
    private Controller controller;

    @BeforeEach
    public void setUp() {
        ui = mock(UserInterface.class);
        garage = mock(ParkingGarage.class);
        paymentMachine = mock(PaymentMachine.class);
        controller = new Controller(ui, garage, paymentMachine);
    }

    @Test
    public void testHandleEntrance() {
        // Arrange
        Ticket ticket = new Ticket("T5");
        when(garage.parkCar()).thenReturn(ticket);
        when(garage.getAvailableSpots()).thenReturn(9);

        // Act
        controller.handleEntrance();

        // Assert
        verify(ui).printMessage("Parking ticket issued: T5");
        verify(ui).printMessage("Available spots: 9");
    }

    @Test
    public void testHandlePayment() {
        // Arrange
        Ticket ticket = new Ticket("T6");
        when(ui.getInput("Enter ticket ID: ")).thenReturn("T6");
        when(ui.getInput("Pay amount: ")).thenReturn("10");
        when(garage.findTicketById("T6")).thenReturn(ticket);
        when(paymentMachine.payTicket(ticket, 10.0)).thenReturn(true);

        // Act
        controller.handlePayment();

        // Assert
        verify(ui).printMessage("Payment processed successfully.");
    }

    @Test
    public void testHandleExit() {
        // Arrange
        Ticket ticket = new Ticket("T7");
        when(ui.getInput("Enter ticket ID: ")).thenReturn("T7");
        when(garage.findTicketById("T7")).thenReturn(ticket);
        when(garage.exitCar(ticket)).thenReturn(true);

        // Act
        controller.handleExit();

        // Assert
        verify(ui).printMessage("Exit successful.");
    }

    @Test
    public void testListAllTickets() {
        // Arrange
        Ticket ticket = new Ticket("T8");
        when(garage.listAllTickets()).thenReturn(List.of(ticket));

        // Act
        controller.listAllTickets();

        // Assert
        verify(ui).printMessage(ticket.toString());
    }
}
