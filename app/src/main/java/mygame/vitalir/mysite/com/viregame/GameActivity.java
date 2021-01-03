package mygame.vitalir.mysite.com.viregame;

import android.content.Intent;
import android.content.res.Resources;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Story story = new Story(cardNames, cardChoiceTexts, cardChoiceInfluences, ourStoryTime);
        Stats player = new Stats();
        textView = (TextView)findViewById(R.id.game_text);
        button_first = (Button)findViewById(R.id.button_first);
        button_second = (Button)findViewById(R.id.button_second);
        button_third = (Button)findViewById(R.id.button_third);
        Card currentCard = story.getCurrentCard();
        setText(currentCard.name, currentCard.first_choice_text,
                currentCard.second_choice_text, currentCard.third_choice_text);
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
                //Toast.makeText(GameActivity.this, R.string.app_name, Toast.LENGTH_SHORT).show();
                story.nextTurn();
                Toast.makeText(GameActivity.this, Integer.valueOf(story.getCurrentTurn()).toString(), Toast.LENGTH_SHORT).show();
                if (!story.notEnd()) {
                    Intent intent = new Intent(GameActivity.this, EndActivity.class);
                    startActivity(intent);
                }
                currentCard = story.getCurrentCard();
                setText(currentCard.name, currentCard.first_choice_text,
                        currentCard.second_choice_text, currentCard.third_choice_text);
             }
        };
        button_first.setOnClickListener(listener);
        button_second.setOnClickListener(listener);
        button_third.setOnClickListener(listener);
    }
    private void setText(String s1, String s2, String s3, String s4) {
        textView.setText(s1);
        button_first.setText(s2);
        button_second.setText(s3);
        button_third.setText(s4);
    }
}
