package mygame.vitalir.mysite.com.viregame;

import java.util.Random;

public class Story {
    private final Card[] cardDeck;
    private final Stats player;
    private final int amountOfTurns;
    private int currentTurn;
    Story(String[] cardNames, String[][] cardChoices,
          int[][] cardChoicesInt, String[][] cardChoicesResult, Stats player, int storyTime) {
        currentTurn = 0;
        cardDeck = new Card[storyTime];
        this.player = player;
        amountOfTurns = storyTime;
        fillCardDeck(cardNames, cardChoices, cardChoicesInt, cardChoicesResult, storyTime);
    }

    public Story(Stats player, int storyTime) {
        currentTurn = 0;
        cardDeck = new Card[storyTime];
        this.player = player;
        amountOfTurns = storyTime;
    }

    public Story(StoryData storyData, Stats player) {
        currentTurn = 0;
        cardDeck = new Card[storyData.storyTime];
        this.player = player;
        amountOfTurns = storyData.storyTime;
        fillCardDeck(storyData.cardNames, storyData.cardChoiceTexts, storyData.cardChoiceInfluences,
                storyData.cardChoiceResults, storyData.storyTime);
    }

    public void fillCardDeck(String[] cardNames, String[][] cardChoices,
                             int[][] cardChoicesInt, String[][] cardChoicesResult, int size) {
        int x = 0;
        for (int i = 0; i < size; ++i) {
            cardDeck[i] = new Card();
            cardDeck[i].name = cardNames[i];
            for (int j = 0; j < Card.numberOfChoices; ++j) {
                cardDeck[i].choice_text[j] = cardChoices[i][j];
                cardDeck[i].choice_influence[j] = new Stats(cardChoicesInt[x+j]);
                cardDeck[i].choice_result[j] = cardChoicesResult[i][j];
            }
            x += 3;
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
            for (int j = 0; j < Card.numberOfChoices; ++j) {
                cardDeck[i].choice_text[j] = chars[randomInt];
                cardDeck[i].choice_influence[j] = new Stats(randomInt, randomInt, randomInt);
                cardDeck[i].choice_result[j] = chars[randomInt];
            }
        }
    }
    public void nextTurn() {
        if (this.notEnd()) {
            ++currentTurn;
        }
    }

    // It'll be better if I create different endings and different stories which depends on
    // what was your past choices but it is homework project so idk if I'll improve this project.
    public boolean notEnd() {
        return currentTurn < amountOfTurns && player.isAlive() && player.isNotMonster();
    }
    public int getCurrentTurn() {
        return currentTurn;
    }
    public int getAmountOfTurns() { return amountOfTurns; }

    public Stats getPlayer() {
        return player;
    }
}
