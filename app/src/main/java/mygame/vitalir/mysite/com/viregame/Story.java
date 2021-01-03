package mygame.vitalir.mysite.com.viregame;

import android.icu.util.ICUUncheckedIOException;

public class Story { // FIXME
    private Card[] cardDeck;
    private final int amountOfTurns;
    private int currentTurn;
    Story(String[] cardNames, String[][] cardChoices,
          int[][] cardChoicesInt,  int storyTime) {
        currentTurn = 0;
        cardDeck = new Card[storyTime];
        amountOfTurns = storyTime;
        fillCardDeck(cardNames, cardChoices, cardChoicesInt, storyTime);
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
    public void nextTurn() {
        if (this.notEnd()) {
            ++currentTurn;
        }
    }
    public boolean notEnd() {
        return currentTurn < amountOfTurns;
    }
    public int getCurrentTurn() {
        return currentTurn;
    }
}
