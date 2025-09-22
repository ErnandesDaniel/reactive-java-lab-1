package org.example.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Deck {

    private int id;

    private String name;
    private String description;
    private LocalDateTime createdAt;
    private List<Card> cards;

    private DeckStatus deckStatus;
    private DeckMetaData deckMetaData;

    private int userId;

    public Deck(int id, int userId, String name, String description,List<Card> cards, DeckStatus deckStatus, DeckMetaData deckMetaData ) {
        this.id = id;
        this.userId=userId;
        this.name = name;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.cards = cards != null ? new ArrayList<>(cards) : new ArrayList<>();

        this.deckStatus = deckStatus != null ? deckStatus : DeckStatus.ACTIVE;
        this.deckMetaData = deckMetaData != null ? deckMetaData : new DeckMetaData(this.cards.size(), 0);
    }
}
