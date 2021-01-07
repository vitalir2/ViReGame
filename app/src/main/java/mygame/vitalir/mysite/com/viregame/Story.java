package mygame.vitalir.mysite.com.viregame;

import java.util.Random;

public class Story {
    private final Card[] cardDeck;
    private final Stats player;
    private final int amountOfTurns;
    private int currentTurn;
    Story(String[] cardNames, String[][] cardChoices,
          int[][] cardChoicesInt,  Stats player, int storyTime) {
        currentTurn = 0;
        cardDeck = new Card[storyTime];
        this.player = player;
        amountOfTurns = storyTime;
        fillCardDeck(cardNames, cardChoices, cardChoicesInt, storyTime);
    }

    public Story(Stats player, int storyTime) {
        currentTurn = 0;
        cardDeck = new Card[storyTime];
        this.player = player;
        amountOfTurns = storyTime;
    }

    public void fillCardDeck(String[] cardNames, String[][] cardChoices,
                             int[][] cardChoicesInt, int size) {
        for (int i = 0; i < size; ++i) {
            cardDeck[i] = new Card();
            cardDeck[i].name = cardNames[i];
            cardDeck[i].first_choice_text = cardChoices[i][0];
            cardDeck[i].second_choice_text = cardChoices[i][1];
            cardDeck[i].third_choice_text = cardChoices[i][2];
            cardDeck[i].first_choice_influence = new Stats(cardChoicesInt[i]);
            cardDeck[i].second_choice_influence = new Stats(cardChoicesInt[i+1]);
            cardDeck[i].third_choice_influence = new Stats(cardChoicesInt[i+2]);
        }
    }
    public Card getCurrentCard() {
        return cardDeck[currentTurn];
    }
    public void generateRandomDeck(int size) { // for testing
        Random random = new Random();
        final int asciiSym = 97;
        final int seed = 100;
        String[] chars = new String[26];
        for (int i = 0; i < chars.length; ++i) {
            chars[i] = "" + (char)(asciiSym + i);
        }
        for (int i = 0; i < size; ++i) {
            int randomInt = random.nextInt(chars.length);
            cardDeck[i] = new Card();
            cardDeck[i].name = chars[randomInt];
            cardDeck[i].first_choice_text = chars[randomInt];
            cardDeck[i].second_choice_text = chars[randomInt];
            cardDeck[i].third_choice_text = chars[randomInt];
            cardDeck[i].first_choice_influence = new Stats(randomInt, randomInt, randomInt);
            cardDeck[i].second_choice_influence = new Stats(randomInt, randomInt, randomInt);
            cardDeck[i].third_choice_influence = new Stats(randomInt, randomInt, randomInt);
        }
    }
    public void nextTurn() {
        if (this.notEnd()) {
            ++currentTurn;
        }
    }
    public boolean notEnd() {
        return currentTurn < amountOfTurns && player.isAlive();
    }
    public int getCurrentTurn() {
        return currentTurn;
    }
    public int getAmountOfTurns() { return amountOfTurns; }

    public Stats getPlayer() {
        return player;
    }
}
