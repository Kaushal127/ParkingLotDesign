package org.example.models;

public class Ticket {
    private String ticketNumber;
    private String slotNumber;

    public Ticket(String ticketNumber, String slotNumber) {
        this.ticketNumber = ticketNumber;
        this.slotNumber = slotNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }
}
