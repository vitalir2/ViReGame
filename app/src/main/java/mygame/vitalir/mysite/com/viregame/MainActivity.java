package mygame.vitalir.mysite.com.viregame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b = findViewById(R.id.button_start);
        b.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, GameActivity.class);
            startActivity(i);
        });
    }
}