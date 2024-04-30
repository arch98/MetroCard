package com.example.geektrust.Entities;

import com.example.geektrust.Enums.PassengerType;

public class PassengerDetails {

    private final PassengerType passengerType;
    private final int count;

    public PassengerDetails(PassengerType passengerType,int count){
        this.passengerType = passengerType;
        this.count =count;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public int getCount() {
        return count;
    }
}
