package com.example.geektrust.Entities;

import com.example.geektrust.Enums.PassengerType;
import com.example.geektrust.Enums.Place;

public class CheckIn {
    private final String cardId;
    private final PassengerType passengerType;
    private final Place place;

    public CheckIn(String cardId,PassengerType passengerType,Place place){
        this.cardId = cardId;
        this.passengerType = passengerType;
        this.place = place;
    }

    public String getCardId() {
        return cardId;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public Place getPlace() {
        return place;
    }
}
