package com.example.cardtest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseCard {

    protected final String title;
    protected final String message;

    @JsonIgnore
    private final CardType cardType;

    public BaseCard(CardType cardType, String title, String message) {
        this.cardType = cardType;
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public CardType getCardType() {
        return cardType;
    }
}
