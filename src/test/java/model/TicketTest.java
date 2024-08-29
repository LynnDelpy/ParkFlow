// Created by Lynn Delpy on 28.08.2024

package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    private Ticket ticket;
    private Date currentTime;

    @BeforeEach
    void setUp() {
        // Initialize the ticket and current time before each test
        ticket = new Ticket("T123");
        currentTime = new Date(); // Default current time
    }

    @Test
    void testGetFee() {
        // Set issue time to 2 hours ago for testing
        long issueTimeMillis = currentTime.getTime() - (2 * 60 * 60 * 1000);
        ticket.issueTime = new Date(issueTimeMillis);

        // Calculate expected fee: 2 hours should be rounded up to 3 hours
        double expectedFee = 3 * 5.0; // $5 per hour
        double actualFee = ticket.getFee(currentTime);

        assertEquals(expectedFee, actualFee, "The fee should be calculated correctly based on the duration.");
    }

    @Test
    void testPay() {
        // Test paying for the ticket
        boolean result = ticket.pay(10.0); // Arbitrary amount, should succeed
        assertTrue(result, "Payment should be successful when the ticket is not yet paid.");

        // Test paying again
        result = ticket.pay(10.0);
        assertFalse(result, "Payment should fail if the ticket has already been paid.");
    }

    @Test
    void testIsPaid() {
        // Test ticket not paid initially
        assertFalse(ticket.isPaid(), "A newly created ticket should not be marked as paid.");

        // Test ticket after payment
        ticket.pay(10.0);
        assertTrue(ticket.isPaid(), "The ticket should be marked as paid after payment.");
    }

    @Test
    void testGetTicketId() {
        assertEquals("T123", ticket.getTicketId(), "The ticket ID should be correctly retrieved.");
    }

    @Test
    void testToString() {
        String expectedString = "Ticket ID: T123, Issued: " + ticket.issueTime + ", Paid: false";
        assertEquals(expectedString, ticket.toString(), "The toString method should return the expected string representation.");
    }
}
