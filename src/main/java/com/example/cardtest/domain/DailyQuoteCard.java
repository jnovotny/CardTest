package com.example.cardtest.domain;

public class DailyQuoteCard extends BaseCard implements Card {

    private final String author;

    public DailyQuoteCard(String title, String message, String author) {
        super(CardType.DAILY_QUOTE, title, message);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
