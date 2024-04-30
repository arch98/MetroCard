package com.example.geektrust.Services;

import com.example.geektrust.Comparator.PassengerComparator;
import com.example.geektrust.Entities.PassengerDetails;
import com.example.geektrust.Enums.PassengerType;
import com.example.geektrust.Enums.Place;
import com.example.geektrust.Interfaces.ICheckInService;
import com.example.geektrust.Interfaces.IPrintSummary;


import java.util.*;

import static java.util.Collections.sort;

public class PrintSummary implements IPrintSummary {


    private ICheckInService checkInService;

    public PrintSummary(ICheckInService checkInService){
        this.checkInService = checkInService;
    }
    public void printSummary(){
        Map<Place,Integer> collectionAtPlaceMap = this.checkInService.getCollectionAtPlaceMap();
        Map<Place,Integer> discountAtPlaceMap = this.checkInService.getDiscountAtPlaceMap();
        Map<Place,Map<PassengerType,Integer>>passengerCountPerPlace = this.checkInService.getPassengerCountPerPlace();

        for(Place place:Place.values()){
            int total_collection = collectionAtPlaceMap.get(place);
            int discount_collection = discountAtPlaceMap.get(place);
            System.out.println("TOTAL_COLLECTION "+place.name()+" "+total_collection+" "+discount_collection);
            System.out.println("PASSENGER_TYPE_SUMMARY");

           ArrayList<PassengerDetails> passengers = new ArrayList<>();
           Map<PassengerType,Integer>mp = passengerCountPerPlace.get(place);
           for(Map.Entry<PassengerType,Integer> passengerTypeIntegerEntry : mp.entrySet()){
              PassengerDetails passengerDetails = new PassengerDetails(passengerTypeIntegerEntry.getKey(),passengerTypeIntegerEntry.getValue());
              passengers.add(passengerDetails);
           }

           sort(passengers,new PassengerComparator());

            for(PassengerDetails passengerDetails:passengers){
                System.out.println(passengerDetails.getPassengerType()+" "+passengerDetails.getCount());
            }
        }
    }
}
