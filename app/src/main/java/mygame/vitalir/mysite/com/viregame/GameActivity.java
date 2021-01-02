package mygame.vitalir.mysite.com.viregame;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    private final int ourStoryTime = 2;
    private final String[] cardNames = {"First", "Second"};
    private final String[][] cardChoiceTexts = {{"1", "2", "3"}, {"1", "2", "3"}};
    private final int[][] cardChoiceInfluences = {{25, 25, 0}, {0, 0, 10}, {-25, 10, 10},
            {0, -25, 25}, {40, -25, -25}, {10, 10, 10}};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Story story = new Story(cardNames, cardChoiceTexts, cardChoiceInfluences, ourStoryTime);
        Stats player = new Stats();
        startGameCycle(story, player);
    }
    private void startGameCycle(Story story, Stats player) {
        while (story.getAmountOfTurns() <= ourStoryTime
        && story.notEnd()) {
            Card currentCard = story.getNextCard();
        }
    }
}
