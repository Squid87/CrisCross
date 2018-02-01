package com.example.tie.criscros;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.tie.criscros.Game.GameActivity;
import com.example.tie.criscros.Registration.RegistrationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_enter)
    Button mButtonEnter;

    @BindView(R.id.button_registration)
    Button mButtonRegistration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButtonEnter.setOnClickListener(v -> startGame("cris"));
        //mButtonRegistration.setOnClickListener(v -> startGame("cross"));
        mButtonRegistration.setOnClickListener(v-> registration());

    }

    private void registration() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void startGame(String s) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("game", s);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
