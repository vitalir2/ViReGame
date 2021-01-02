package mygame.vitalir.mysite.com.viregame;

public class Story { // FIXME
    private Card[] cardDeck;
    private int amountOfTurns;
    Story(String[] cardNames, String[][] cardChoices,
          int[][] cardChoicesInt,  int storyTime) {
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
    public Card getNextCard() {
        return cardDeck[amountOfTurns];
    }
    public boolean notEnd() {
        return true;
    }
    public int getAmountOfTurns() {
        return amountOfTurns;
    }
}
