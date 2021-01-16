/*
link on GitHub repo: https://github.com/vitalir2/ViReGame
 */

package mygame.vitalir.mysite.com.viregame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b = (Button)findViewById(R.id.button_start);
        final ImageButton button_exit = (ImageButton)findViewById(R.id.button_exit);
        b.setOnClickListener(v -> {
            Intent i = new Intent(this, GameActivity.class);
            startActivity(i);
        });
        button_exit.setOnClickListener(v -> finishAffinity());
    }
}