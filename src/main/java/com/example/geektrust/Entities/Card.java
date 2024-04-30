package com.example.geektrust.Entities;

public class Card {

    private String cardId;
    private int amount;

    public Card(String cardId,int amount){
        this.cardId = cardId;
        this.amount =amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getCardId() {
        return cardId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
