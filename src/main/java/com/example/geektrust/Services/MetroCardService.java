package com.example.geektrust.Services;

import com.example.geektrust.Entities.Card;
import com.example.geektrust.Interfaces.IMetroCardService;

import java.util.HashMap;
import java.util.Map;

public class MetroCardService implements IMetroCardService {

    //Holds the collection of cards mapped to the cardIds
    private Map<String,Card> cardMap;

    public MetroCardService(){
        //Creating an empty hashmap
        cardMap = new HashMap<>();
    }
    public  void addCard(String cardNumber,int amount){
        //Creating a new card
        Card card = new Card(cardNumber,amount);
        this.cardMap.put(cardNumber,card);
    }


    public int transcation(String cardId,int amount){
        Card card  = this.cardMap.get(cardId);
        int amountIncard = card.getAmount();
        int difference = amountIncard-amount;

        // if the amount in the card is less than the amount to be debited.
        if(difference <= 0){
            card.setAmount(0);
            this.cardMap.put(cardId,card);
            return (difference*-1);

        }

        card.setAmount(difference);
        this.cardMap.put(cardId,card);
        return 0;
    }
}
