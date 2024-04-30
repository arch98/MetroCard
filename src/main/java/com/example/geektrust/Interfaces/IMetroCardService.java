package com.example.geektrust.Interfaces;

import com.example.geektrust.Entities.Card;

public interface IMetroCardService {

    //This is to add a new card with a cardNumber and an amount
     void addCard(String cardNumber,int amount);

    //Get the amount balance from the card pertaining to a transcation
    int transcation(String cardId,int amount);

}
