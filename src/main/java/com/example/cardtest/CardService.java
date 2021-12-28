package com.example.cardtest;

import com.example.cardtest.domain.Card;
import com.example.cardtest.domain.CardType;
import com.example.cardtest.domain.DailyQuoteCard;
import com.example.cardtest.domain.StatusUpdateCard;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CardService {

    private List<Card> cards = new ArrayList<>();

    @PostConstruct
    public void init() throws Exception {
        Resource resource = new ClassPathResource("cards.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] vars = line.split(",");
            CardType cardType = CardType.valueOf(vars[0].trim());
            switch (cardType) {
                case DAILY_QUOTE:
                    cards.add(createDailyQuoteCard(vars));
                    break;
                case STATUS_UPDATE:
                    cards.add(createStatusUpdateCard(vars));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown card type = " + cardType);
            }
        }
        reader.close();
    }

    private Card createDailyQuoteCard(String[] vars) {
        return new DailyQuoteCard(vars[1].trim(), vars[2].trim(), vars[3].trim());
    }

    private Card createStatusUpdateCard(String[] vars) {
        return new StatusUpdateCard(vars[1].trim(), vars[2].trim(), vars[3].trim(), vars[4].trim());
    }

    public List<Card> getCards(long userId) {
        return cards;
    }
}
