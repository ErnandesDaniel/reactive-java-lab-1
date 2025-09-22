package org.example.generators;

import org.example.models.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeckGenerator {

    //сгенерированные значения соответсвеовали прещметной области - не было миллиона карт в колоде
    private static final Random RAND = ThreadLocalRandom.current();

    private static final String[] NAMES = {"Java Basics", "SQL Queries", "Algorithms", "Design Patterns", "Spring Boot"};

    private static final String[] DESCRIPTIONS = {"Beginner level", "Advanced topics", "For interviews", "Daily practice", "Quick review"};

    public static List<Deck> generateDecksByCycle(int count) {


        List<Deck> decks = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            int userId = 1;

            String name = NAMES[RAND.nextInt(NAMES.length)];

            String description = DESCRIPTIONS[RAND.nextInt(DESCRIPTIONS.length)];

            List<Card> cards = new ArrayList<>();

            int cardCount = RAND.nextInt(16) + 5; // 5-20 cards

            for (int j = 0; j < cardCount; j++) {
                cards.add(new Card(j,"Question №" + j, "Response №"+j));
            }

            DeckStatus status = DeckStatus.values()[RAND.nextInt(DeckStatus.values().length)];

            DeckMetaData metaData = new DeckMetaData(cardCount, RAND.nextInt(cardCount + 1));

            decks.add(new Deck(i + 1, userId, name, description, cards, status, metaData));
        }


        return decks;

    }

    public static List<Deck> generateDecksByStreamAPI(int count) {

        return IntStream.range(0, count)
                .mapToObj(i -> {
                    int userId = 1;
                    String name = NAMES[RAND.nextInt(NAMES.length)];
                    String description = DESCRIPTIONS[RAND.nextInt(DESCRIPTIONS.length)];

                    int cardCount = RAND.nextInt(16) + 5; // 5-20 карт
                    List<Card> cards = IntStream.range(0, cardCount)
                            .mapToObj(j -> new Card(j,"Question №" + j, "Response №"+j))
                            .collect(Collectors.toList());

                    DeckStatus status = DeckStatus.values()[RAND.nextInt(DeckStatus.values().length)];
                    DeckMetaData metaData = new DeckMetaData(cardCount, RAND.nextInt(cardCount + 1)); // studied <= total

                    return new Deck(i + 1, userId, name, description, cards, status, metaData);
                })
                .collect(Collectors.toList());
    }
}