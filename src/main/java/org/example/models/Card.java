package org.example.models;
import java.time.LocalDateTime;

public class Card {

    private int id;
    private String answer;
    private String response;
    private LocalDateTime createdAt;

    public Card(int id, String answer, String response, LocalDateTime createdAt) {
        this.id = id;
        this.answer = answer;
        this.response = response;
        this.createdAt = LocalDateTime.now();
    }
}