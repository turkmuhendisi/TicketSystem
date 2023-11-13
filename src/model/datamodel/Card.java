package model.datamodel;

import model.model_enums.CardType;

public abstract class Card {
    private int cardID;
    private CardType cardType;
    private double balance;

    public Card(CardType cardType, double balance) {
        this.cardType = cardType;
        this.balance = balance;
    }

    public Card(CardType cardType) {
        this.cardType = cardType;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
