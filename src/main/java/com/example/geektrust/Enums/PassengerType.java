package com.example.geektrust.Enums;

public enum PassengerType {
    ADULT(200),
    SENIOR_CITIZEN(100),
    KID(50);

    private int ticket_price;

    PassengerType(int ticket_price){
        this.ticket_price = ticket_price;
    }

    public int getTicket_price(){
        return this.ticket_price;
    }
}
