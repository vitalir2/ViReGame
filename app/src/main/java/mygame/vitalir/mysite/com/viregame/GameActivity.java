package mygame.vitalir.mysite.com.viregame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    private final int ourStoryTime = 2;
    private final String[] cardNames = {"First", "Second"};
    private final String[][] cardChoiceTexts = {{"1", "2", "3"}, {"1", "2", "3"}};
    private final int[][] cardChoiceInfluences = {{25, 25, 0}, {0, 0, 10}, {-25, 10, 10},
            {0, -25, 25}, {40, -25, -25}, {10, 10, 10}};

    private Button button_first;
    private Button button_second;
    private Button button_third;
    private TextView questDescription;
    private TextView stat_first;
    private TextView stat_second;
    private TextView stat_third;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //Story story = new Story(cardNames, cardChoiceTexts, cardChoiceInfluences, ourStoryTime);
        Story story = new Story(new Stats(), 5);
        story.generateRandomDeck(5);
        questDescription = findViewById(R.id.game_text);
        button_first = findViewById(R.id.button_first);
        button_second = findViewById(R.id.button_second);
        button_third = findViewById(R.id.button_third);
        stat_first = findViewById(R.id.resource1);
        stat_second = findViewById(R.id.resource2);
        stat_third = findViewById(R.id.resource3);
        Card currentCard = story.getCurrentCard();
        setText(currentCard.name, currentCard.first_choice_text,
                currentCard.second_choice_text, currentCard.third_choice_text);
        Stats player = story.getPlayer();
        changeStats(player);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                Card currentCard = story.getCurrentCard();
                if (id == R.id.button_first) {
                    player.changeValue(currentCard.first_choice_influence);
                } else if (id == R.id.button_second) {
                    player.changeValue(currentCard.second_choice_influence);
                } else if (id == R.id.button_third) {
                    player.changeValue(currentCard.third_choice_influence);
                }
                story.nextTurn();
                if (story.notEnd()) {
                    currentCard = story.getCurrentCard();
                    setText(currentCard.name, currentCard.first_choice_text,
                            currentCard.second_choice_text, currentCard.third_choice_text);
                    changeStats(player);
                } else {
                    Intent intent = new Intent(GameActivity.this, EndActivity.class);
                    intent.putExtra("CurrentTurn", story.getCurrentTurn() + 1);
                    intent.putExtra("isDied", story.getCurrentTurn() != story.getAmountOfTurns());
                    startActivity(intent);
                }
             }
        };
        button_first.setOnClickListener(listener);
        button_second.setOnClickListener(listener);
        button_third.setOnClickListener(listener);
    }
    private void setText(String s1, String s2, String s3, String s4) {
        questDescription.setText(s1);
        button_first.setText(s2);
        button_second.setText(s3);
        button_third.setText(s4);
    }
    @SuppressLint("SetTextI18n")
    private void changeStats(Stats player) {
        stat_first.setText(Integer.valueOf(player.stat1).toString());
        stat_second.setText(Integer.valueOf(player.stat2).toString());
        stat_third.setText(Integer.valueOf(player.stat3).toString());
    }
}
