package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ParkingGarageTest {

    private ParkingGarage garage;
    private Ticket ticket;

    @BeforeEach
    public void setUp() {
        garage = new ParkingGarage(10, new Display());
    }

    @Test
    public void testParkCar() {
        Ticket ticket = garage.parkCar();
        assertNotNull(ticket, "Ticket should not be null when there is an available spot.");
        assertEquals(9, garage.getAvailableSpots(), "Available spots should decrease by 1 after parking a car.");
    }

    @Test
    public void testFindTicketById() {
        Ticket ticket = garage.parkCar();
        Ticket foundTicket = garage.findTicketById(ticket.getTicketId());
        assertNotNull(foundTicket, "Ticket should be found by its ID.");
        assertEquals(ticket.getTicketId(), foundTicket.getTicketId(), "Found ticket ID should match the original ticket ID.");
    }

    @Test
    void testExitCar() {
        Ticket ticket = garage.parkCar();
        ticket.pay(10.0);
        boolean result = garage.exitCar(ticket);
        assertTrue(result, "Car should exit successfully when the ticket is paid.");
        assertEquals(10, garage.getAvailableSpots(), "The number of available spots should be updated correctly.");
    }

    @Test
    public void testListAllTickets() {
        garage.parkCar();
        List<Ticket> tickets = garage.listAllTickets();
        assertFalse(tickets.isEmpty(), "There should be at least one ticket issued.");
    }
}
