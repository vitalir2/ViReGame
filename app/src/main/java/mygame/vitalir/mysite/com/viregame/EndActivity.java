package mygame.vitalir.mysite.com.viregame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {
    Button button_return;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        button_return = (Button)findViewById(R.id.button_return);
        button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EndActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
