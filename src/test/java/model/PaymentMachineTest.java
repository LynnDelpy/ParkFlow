package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class PaymentMachineTest {
    @Test
    public void testPayTicket() {
        Ticket ticket = new Ticket("T3");
        PaymentMachine paymentMachine = new PaymentMachine();
        boolean success = paymentMachine.payTicket(ticket, 10.0);
        assertTrue(success, "Payment should be processed successfully with sufficient amount.");
        assertTrue(ticket.isPaid(), "Ticket should be marked as paid after successful payment.");
    }

    @Test
    public void testInsufficientPayment() {
        Ticket ticket = new Ticket("T4");
        PaymentMachine paymentMachine = new PaymentMachine();
        boolean success = paymentMachine.payTicket(ticket, 2.0);
        assertFalse(success, "Payment should fail with insufficient amount.");
    }
}
