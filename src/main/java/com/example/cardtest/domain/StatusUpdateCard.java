package com.example.cardtest.domain;

public class StatusUpdateCard extends BaseCard implements Card {

    private final String icon;
    private final String button;

    public StatusUpdateCard(String title, String message, String icon, String button) {
        super(CardType.STATUS_UPDATE, title, message);
        this.icon = icon;
        this.button = button;
    }

    public String getIcon() {
        return icon;
    }

    public String getButton() {
        return button;
    }
}
