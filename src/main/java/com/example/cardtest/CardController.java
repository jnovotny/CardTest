package com.example.cardtest;

import com.example.cardtest.domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping(value = "/{userId}")
    public List<Card> getCards(@PathVariable Long userId) {
        return cardService.getCards(userId);
    }
}