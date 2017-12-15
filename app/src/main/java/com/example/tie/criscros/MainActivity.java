package com.example.tie.criscros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButtonCris = (Button) findViewById(R.id.button_new_game_cris);
        mButtonCris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        Button mButtonCross = (Button) findViewById(R.id.button_new_game_cros);
        mButtonCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void startGame() {
        Intent intent = new Intent(this, GameActivity.class);
//        intent.putExtra("cris_or_cros",s);
        startActivity(intent);

    }

}
