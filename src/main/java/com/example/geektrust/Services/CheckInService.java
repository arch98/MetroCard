package com.example.geektrust.Services;

import com.example.geektrust.Entities.CheckIn;
import com.example.geektrust.Enums.PassengerType;
import com.example.geektrust.Enums.Place;
import com.example.geektrust.Interfaces.ICheckInService;
import com.example.geektrust.Interfaces.IMetroCardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckInService implements ICheckInService {
    private Map<Place,Integer> collectionAtPlaceMap;
    private Map<Place,Integer> discountAtPlaceMap;
    private Map<Place,Map<PassengerType,Integer>>passengerCountPerPlace;
    private List<String> passengerMap;
    private IMetroCardService metroCardService;

    public CheckInService(IMetroCardService metroCardService){
        this.metroCardService = metroCardService;
        this.passengerMap = new ArrayList<>();
        this.discountAtPlaceMap = new HashMap<>();
        this.collectionAtPlaceMap = new HashMap<>();
        this.passengerCountPerPlace = new HashMap<>();

        for(Place place:Place.values()){
            discountAtPlaceMap.put(place,0);
            collectionAtPlaceMap.put(place,0);
            passengerCountPerPlace.put(place,new HashMap<>());
        }
    }

    private void get_remain(String cardId,int amount_to_collect,Place place){
        int collected_money = this.collectionAtPlaceMap.get(place) + amount_to_collect;
        int remaining_amount = this.metroCardService.transcation(cardId,amount_to_collect);
        if(remaining_amount > 0){
            collected_money = collected_money + (remaining_amount*2/100);
        }
        this.collectionAtPlaceMap.put(place,collected_money);
    }

    public void checkIn(CheckIn checkIn){
        String cardId = checkIn.getCardId();
        Place place  = checkIn.getPlace();
        PassengerType passengerType = checkIn.getPassengerType();
        int amount_to_collect = passengerType.getTicket_price();

        if(this.passengerMap.contains(cardId)){
            amount_to_collect = amount_to_collect/2;
            int discount_given =  amount_to_collect + this.discountAtPlaceMap.get(place);
            this.discountAtPlaceMap.put(place,discount_given);
            get_remain(cardId,amount_to_collect,place);
            this.passengerMap.remove(cardId);
        }else{
            get_remain(cardId,amount_to_collect,place);
            this.passengerMap.add(cardId);
        }

        Map<PassengerType,Integer>PassengerCount = this.passengerCountPerPlace.get(place);
        if(PassengerCount.containsKey(passengerType)){
            int val = PassengerCount.get(passengerType) + 1;
            PassengerCount.put(passengerType,val);
        }else{
            PassengerCount.put(passengerType,1);
        }

        this.passengerCountPerPlace.put(place,PassengerCount);
    }

    public Map<Place, Integer> getCollectionAtPlaceMap() {
        return collectionAtPlaceMap;
    }

    public Map<Place, Integer> getDiscountAtPlaceMap() {
        return discountAtPlaceMap;
    }

    public Map<Place,Map<PassengerType,Integer>> getPassengerCountPerPlace() {
        return passengerCountPerPlace;
    }
}
