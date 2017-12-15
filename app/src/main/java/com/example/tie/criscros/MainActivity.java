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
                startGame("cris");
            }
        });

        Button mButtonCross = (Button) findViewById(R.id.button_new_game_cros);
        mButtonCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame("cross");
            }
        });

    }

    public void startGame(String s) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("game", s);
        startActivity(intent);

    }

}
