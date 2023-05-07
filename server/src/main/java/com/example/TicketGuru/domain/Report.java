package com.example.TicketGuru.domain;

public class Report {

    // luokka, jossa kerätään raportin tiedot

    private String event;

    private String eventTicketType;

    private int amountSoldTickets;

    private double price;

    private double total;

    private Long eventTypeId;

    public String getEvent() {
        return event;
    }

    public String getEventTicketType() {
        return eventTicketType;
    }

    public double getAmountSoldTickets() {
        return amountSoldTickets;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return total;
    }


    public Long getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Long eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setEventTicketType(String eventTicketType) {
        this.eventTicketType = eventTicketType;
    }

    public void setAmountSoldTickets(int amountSoldTickets) {
        this.amountSoldTickets = amountSoldTickets;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotal(double price, int amountSoldTickets) {
        total = price * amountSoldTickets;
        //this.total = total;
    }

    
}
