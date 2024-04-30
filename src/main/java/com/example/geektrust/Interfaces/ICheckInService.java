package com.example.geektrust.Interfaces;


import com.example.geektrust.Entities.CheckIn;
import com.example.geektrust.Enums.PassengerType;
import com.example.geektrust.Enums.Place;

import java.util.Map;

public interface ICheckInService {

    void checkIn(CheckIn checkIn);

    Map<Place, Integer> getCollectionAtPlaceMap();
    Map<Place, Integer> getDiscountAtPlaceMap();
    Map<Place, Map<PassengerType, Integer>> getPassengerCountPerPlace();
}
