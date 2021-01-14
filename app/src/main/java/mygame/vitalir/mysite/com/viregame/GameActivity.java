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
        Stats player = new Stats();
        Story story = new Story(new StoryData(), player);
        //Story story = new Story(new Stats(), 5);
        //story.generateRandomDeck(5);
        questDescription = (TextView)findViewById(R.id.game_text);
        button_first = (Button)findViewById(R.id.button_first);
        button_second = (Button)findViewById(R.id.button_second);
        button_third = (Button)findViewById(R.id.button_third);
        stat_first = (TextView)findViewById(R.id.resource1);
        stat_second = (TextView)findViewById(R.id.resource2);
        stat_third = (TextView)findViewById(R.id.resource3);
        Card currentCard = story.getCurrentCard();
        setText(currentCard.name, currentCard.choice_text[0],
                currentCard.choice_text[1], currentCard.choice_text[2]);
        showViewStats(player);
        View.OnClickListener listener = v -> {
            int id = v.getId();
            String result = "";
            Card currentCard1 = story.getCurrentCard();
            if (id == R.id.button_first) {
                player.changeValue(currentCard1.choice_influence[0]);
                result = currentCard1.choice_result[0];
            } else if (id == R.id.button_second) {
                player.changeValue(currentCard1.choice_influence[1]);
                result = currentCard1.choice_result[1];
            } else if (id == R.id.button_third) {
                player.changeValue(currentCard1.choice_influence[2]);
                result = currentCard1.choice_result[2];
            }
            story.nextTurn();
            if (story.notEnd()) {
                currentCard1 = story.getCurrentCard();
                setText(result + " " + currentCard1.name, currentCard1. choice_text[0],
                        currentCard1.choice_text[1], currentCard1.choice_text[2]);
                showViewStats(player);
            } else {
                Intent intent = new Intent(GameActivity.this, EndActivity.class);
                intent.putExtra("CurrentTurn", story.getCurrentTurn() + 1);
                intent.putExtra("isDied", story.getCurrentTurn() != story.getAmountOfTurns());
                intent.putExtra("FinalTextAdding", result);
                startActivity(intent);
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
    private void showViewStats(Stats player) {
        stat_first.setText(Integer.valueOf(player.health).toString());
        stat_second.setText(Integer.valueOf(player.mood).toString());
        stat_third.setText(Integer.valueOf(player.money).toString());
    }

    @Override
    public void onBackPressed() {
    }
}
