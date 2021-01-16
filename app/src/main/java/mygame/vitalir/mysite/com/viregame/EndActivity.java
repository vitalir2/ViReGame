package mygame.vitalir.mysite.com.viregame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {
    Button button_return;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        button_return = (Button)findViewById(R.id.button_return);
        textView = findViewById(R.id.text_final);
        Intent intent = getIntent();
        int numberOfTurns = intent.getIntExtra("CurrentTurn", 0);
        String finalText = "";
        if (intent.getBooleanExtra("isDied", false)) {
            finalText = getString(R.string.text_result1) + numberOfTurns;
            if (numberOfTurns % 10 == 1 && numberOfTurns % 100 != 11) {
                finalText += getString(R.string.text_result2_1);
            } else if ((numberOfTurns % 100 != 12 && numberOfTurns % 100 != 13
                    && numberOfTurns % 100 != 14) && (numberOfTurns % 10 == 2
                    || numberOfTurns % 10 == 3 || numberOfTurns % 10 == 4)) {
                finalText += getString(R.string.text_result2_2);
            } else {
                finalText += getString(R.string.text_result2_3);
            }
        } else {
            finalText += intent.getStringExtra("FinalTextAdding");
        }
        textView.setText(finalText);
        button_return.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
    }

    @Override
    public void onBackPressed() {
    }
}
