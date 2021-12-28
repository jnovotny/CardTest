package com.example.cardtest;

import com.example.cardtest.domain.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CardTestApplication.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
public class CardControllerIntegrationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetCards() {

        ResponseEntity<List> responseEntity =
                restTemplate.getForEntity("http://localhost:" + port + "/cards/123", List.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
        List<?> cards = responseEntity.getBody();
        assertEquals(2, cards.size());
    }
}