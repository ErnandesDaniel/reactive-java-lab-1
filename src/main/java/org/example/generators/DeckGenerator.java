package org.example.generators;

import org.example.models.Card.Card;
import org.example.models.Deck.Deck;
import org.example.models.Deck.DeckAvailability;
import org.example.models.Deck.DeckCardStats;
import org.example.models.User.User;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class DeckGenerator {

    //сгенерированные значения соответствовали предметной области - не было миллиона карт в колоде

//    private static final String[] deckNames = {"Java Basics", "SQL Queries", "Algorithms", "Design Patterns", "Spring Boot"};
//    private static final String[] userLogins = {"alice", "bob", "charlie", "diana", "evan", "fiona"};
//
//    private List<User> users;
//
//    DeckGenerator(){
//
//
//
//        this.users=IntStream.range(0, userLogins.length)
//                .mapToObj(i -> new User(i + 1, userLogins[i]))
//                .toList();
//
//        Random random = new Random();
//
//        users.forEach(user -> {
//            int deckCount = 1 + random.nextInt(4);
//            List<Deck> decks = DeckGenerator.generateDecks(deckCount, random);
//            user.setDecks(decks);
//        });
//
//
//
//    }
//    public static List<Deck> generateDecksForUser(int deckAmount, User user) {
//
//        List<Deck> decks = new ArrayList<>();
//
//        for (int i = 0; i < deckAmount; i++) {
//
//            int userId = 1;
//
//            String name = deckNames[randomGenerator.nextInt(deckNames.length)];
//
//            String description = DESCRIPTIONS[randomGenerator.nextInt(DESCRIPTIONS.length)];
//
//            ArrayList<Card> cards = new ArrayList<>();
//
//            int cardCount = randomGenerator.nextInt(16) + 5; // 5-20 cards
//
//            for (int j = 0; j < cardCount; j++) {
//                cards.add(new Card(j,"Question №" + j, "Response №"+j));
//            }
//
//            DeckAvailability status = DeckAvailability.values()[randomGenerator.nextInt(DeckAvailability.values().length)];
//
//            DeckCardStats metaData = new DeckCardStats(cardCount, randomGenerator.nextInt(cardCount + 1));
//
//            decks.add(new Deck(i + 1, name, status, metaData));
//        }
//
//
//        return decks;
//
//    }

//    public static List<Deck> generateDecksByStreamAPI(int count) {
//
//        return IntStream.range(0, count)
//                .mapToObj(i -> {
//                    int userId = 1;
//                    String name = NAMES[RAND.nextInt(NAMES.length)];
//                    String description = DESCRIPTIONS[RAND.nextInt(DESCRIPTIONS.length)];
//
//                    int cardCount = RAND.nextInt(16) + 5; // 5-20 карт
//                    List<Card> cards = IntStream.range(0, cardCount)
//                            .mapToObj(j -> new Card(j,"Question №" + j, "Response №"+j))
//                            .collect(Collectors.toList());
//
//                    DeckStatus status = DeckStatus.values()[RAND.nextInt(DeckStatus.values().length)];
//                    DeckMetaData metaData = new DeckMetaData(cardCount, RAND.nextInt(cardCount + 1)); // studied <= total
//
//                    return new Deck(i + 1, userId, name, description, cards, status, metaData);
//                })
//                .collect(Collectors.toList());
//    }

    //генерировать статистику с помощью разных методов, а не сами по себе сущности предметной области

}