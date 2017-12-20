package com.example.tie.criscros;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton mImageButton1;
    ImageButton mImageButton2;
    ImageButton mImageButton3;
    ImageButton mImageButton4;
    ImageButton mImageButton5;
    ImageButton mImageButton6;
    ImageButton mImageButton7;
    ImageButton mImageButton8;
    ImageButton mImageButton9;
    Button mButtonNewGame;
    TextView mWinner;


    private int[][] field = new int[3][3];
    public String crisOrCross;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initBind();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = 2;
            }
        }
        Intent intent = getIntent();
        crisOrCross = intent.getStringExtra("game");

        mImageButton1.setOnClickListener(this);
        mImageButton2.setOnClickListener(this);
        mImageButton3.setOnClickListener(this);
        mImageButton4.setOnClickListener(this);
        mImageButton5.setOnClickListener(this);
        mImageButton6.setOnClickListener(this);
        mImageButton7.setOnClickListener(this);
        mImageButton8.setOnClickListener(this);
        mImageButton9.setOnClickListener(this);
        mButtonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initBind() {
        mWinner = (TextView) findViewById(R.id.winner_text_view);
        mImageButton1 = (ImageButton) findViewById(R.id.one);
        mImageButton2 = (ImageButton) findViewById(R.id.two);
        mImageButton3 = (ImageButton) findViewById(R.id.three);
        mImageButton4 = (ImageButton) findViewById(R.id.four);
        mImageButton5 = (ImageButton) findViewById(R.id.five);
        mImageButton6 = (ImageButton) findViewById(R.id.six);
        mImageButton7 = (ImageButton) findViewById(R.id.seven);
        mImageButton8 = (ImageButton) findViewById(R.id.eight);
        mImageButton9 = (ImageButton) findViewById(R.id.nine);
        mButtonNewGame = (Button) findViewById(R.id.new_game);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.one:
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton1.setImageDrawable(getDrawable(R.drawable.cros));
                    field[0][0] = 0;
                    mImageButton1.setEnabled(false);
                    checkWinn();
                    nextMove();
                    break;
                }
                mImageButton1.setImageDrawable(getDrawable(R.drawable.cris));
                field[0][0] = 1;
                mImageButton1.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.two:
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton2.setImageDrawable(getDrawable(R.drawable.cros));
                    field[0][1] = 0;
                    mImageButton2.setEnabled(false);
                    checkWinn();
                    nextMove();
                    break;
                }
                mImageButton2.setImageDrawable(getDrawable(R.drawable.cris));
                field[0][1] = 1;
                mImageButton2.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.three:
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton3.setImageDrawable(getDrawable(R.drawable.cros));
                    field[0][2] = 0;
                    mImageButton3.setEnabled(false);
                    checkWinn();
                    nextMove();
                    break;
                }
                mImageButton3.setImageDrawable(getDrawable(R.drawable.cris));
                field[0][2] = 1;
                mImageButton3.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.four:
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton4.setImageDrawable(getDrawable(R.drawable.cros));
                    field[1][0] = 0;
                    mImageButton4.setEnabled(false);
                    checkWinn();
                    nextMove();
                    break;
                }
                mImageButton4.setImageDrawable(getDrawable(R.drawable.cris));
                field[1][0] = 1;
                mImageButton4.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.five:
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton5.setImageDrawable(getDrawable(R.drawable.cros));
                    field[1][1] = 0;
                    mImageButton5.setEnabled(false);
                    checkWinn();
                    nextMove();
                    break;
                }
                mImageButton5.setImageDrawable(getDrawable(R.drawable.cris));
                field[1][1] = 1;
                mImageButton5.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.six:
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton6.setImageDrawable(getDrawable(R.drawable.cros));
                    field[1][2] = 0;
                    mImageButton6.setEnabled(false);
                    checkWinn();
                    nextMove();
                    break;
                }
                mImageButton6.setImageDrawable(getDrawable(R.drawable.cris));
                field[1][2] = 1;
                mImageButton6.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.seven:
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton7.setImageDrawable(getDrawable(R.drawable.cros));
                    field[2][0] = 0;
                    mImageButton7.setEnabled(false);
                    checkWinn();
                    nextMove();
                    break;
                }
                mImageButton7.setImageDrawable(getDrawable(R.drawable.cris));
                field[2][0] = 1;
                mImageButton7.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.eight:
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton8.setImageDrawable(getDrawable(R.drawable.cros));
                    field[2][1] = 0;
                    mImageButton8.setEnabled(false);
                    checkWinn();
                    nextMove();
                    break;
                }
                mImageButton8.setImageDrawable(getDrawable(R.drawable.cris));
                field[2][1] = 1;
                mImageButton8.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.nine:
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton9.setImageDrawable(getDrawable(R.drawable.cros));
                    field[2][2] = 0;
                    mImageButton9.setEnabled(false);
                    checkWinn();
                    nextMove();
                    break;
                }
                mImageButton9.setImageDrawable(getDrawable(R.drawable.cris));
                field[2][2] = 1;
                mImageButton9.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.new_game:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void nextMove() {
        Random randNumber = new Random();
        int i = randNumber.nextInt(3);
        int j = randNumber.nextInt(3);

        if (Objects.equals(crisOrCross, "cris")) {
            if (field[i][j] == 2) {
                field[i][j] = 0;
                if (i == 0 && j == 0) {
                    mImageButton1.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton1.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 0 && j == 1) {
                    mImageButton2.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton2.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 0 && j == 2) {
                    mImageButton3.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton3.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 1 && j == 0) {
                    mImageButton4.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton4.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 1 && j == 1) {
                    mImageButton5.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton5.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 1 && j == 2) {
                    mImageButton6.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton6.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 2 && j == 0) {
                    mImageButton7.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton7.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 2 && j == 1) {
                    mImageButton8.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton8.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 2 && j == 2) {
                    mImageButton9.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton9.setEnabled(false);
                    checkWinn();
                    return;
                }
            } else {
                checkWinn();
                nextMove();
            }
        }
        if (Objects.equals(crisOrCross, "cross")) {
            if (field[i][j] == 2) {
                field[i][j] = 1;
                if (i == 0 && j == 0) {
                    mImageButton1.setImageDrawable(getDrawable(R.drawable.cris));
                    mImageButton1.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 0 && j == 1) {
                    mImageButton2.setImageDrawable(getDrawable(R.drawable.cris));
                    mImageButton2.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 0 && j == 2) {
                    mImageButton3.setImageDrawable(getDrawable(R.drawable.cris));
                    mImageButton3.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 1 && j == 0) {
                    mImageButton4.setImageDrawable(getDrawable(R.drawable.cris));
                    mImageButton4.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 1 && j == 1) {
                    mImageButton5.setImageDrawable(getDrawable(R.drawable.cris));
                    mImageButton5.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 1 && j == 2) {
                    mImageButton6.setImageDrawable(getDrawable(R.drawable.cris));
                    mImageButton6.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 2 && j == 0) {
                    mImageButton7.setImageDrawable(getDrawable(R.drawable.cris));
                    mImageButton7.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 2 && j == 1) {
                    mImageButton8.setImageDrawable(getDrawable(R.drawable.cris));
                    mImageButton8.setEnabled(false);
                    checkWinn();
                    return;
                }
                if (i == 2 && j == 2) {
                    mImageButton9.setImageDrawable(getDrawable(R.drawable.cris));
                    mImageButton9.setEnabled(false);
                    checkWinn();
                    return;
                }
            } else {
                checkWinn();
                nextMove();
            }

        }
    }

    public void checkWinn() {

        for (int i = 0; i < 3; i++) {
            int hor1 = 0;
            int ver1 = 0;
            int hor0 = 0;
            int ver0 = 0;

            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 1) {
                    hor1++;
                }
                if (field[i][j] == 0) {
                    hor0++;
                }
                if (field[j][i] == 1) {
                    ver1++;
                }
                if (field[j][i] == 0) {
                    ver0++;
                }
            }
            if (hor1 == 3 || ver1 == 3) {
                mWinner.setText("Выйграли Крестики!");
                disableField();
            }
            if (hor0 == 3 || ver0 == 3) {
                mWinner.setText("Выйграли Нолики!");
                disableField();
            }
        }
        int mdig1 = 0;
        int supdig1 = 0;
        int mdig0 = 0;
        int supdig0 = 0;

        for (int i = 0; i < 3; i++) {
            if (field[i][i] == 1) {
                mdig1++;
            }
            if (field[i][i] == 0) {
                mdig0++;
            }
            if (field[i][2 - i] == 1) {
                supdig1++;
            }
            if (field[i][2 - i] == 0) {
                supdig0++;
            }
        }
        if (mdig1 == 3 || supdig1 == 3) {
            mWinner.setText("Выйграли Крестики!");
            disableField();
        }
        if (mdig0 == 3 || supdig0 == 3) {
            mWinner.setText("Выйграли Нолики!");
            disableField();
        }
    }

    private void disableField() {
        mImageButton1.setEnabled(false);
        mImageButton2.setEnabled(false);
        mImageButton3.setEnabled(false);
        mImageButton4.setEnabled(false);
        mImageButton5.setEnabled(false);
        mImageButton6.setEnabled(false);
        mImageButton7.setEnabled(false);
        mImageButton8.setEnabled(false);
        mImageButton9.setEnabled(false);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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



