package com.example.tie.criscros;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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
    Button mButtonBack;
    TextView mWinner;

    int[][] field = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initBind();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = 2;
            }
        }
        mImageButton1.setOnClickListener(this);
        mImageButton2.setOnClickListener(this);
        mImageButton3.setOnClickListener(this);
        mImageButton4.setOnClickListener(this);
        mImageButton5.setOnClickListener(this);
        mImageButton6.setOnClickListener(this);
        mImageButton7.setOnClickListener(this);
        mImageButton8.setOnClickListener(this);
        mImageButton9.setOnClickListener(this);

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
        mButtonBack = (Button) findViewById(R.id.back);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.one:
                mImageButton1.setImageDrawable(getDrawable(R.drawable.cris));
                field[0][0] = 1;
                mImageButton1.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.two:
                mImageButton2.setImageDrawable(getDrawable(R.drawable.cris));
                field[0][1] = 1;
                mImageButton2.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.three:
                mImageButton3.setImageDrawable(getDrawable(R.drawable.cris));
                field[0][2] = 1;
                mImageButton3.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.four:
                mImageButton4.setImageDrawable(getDrawable(R.drawable.cris));
                field[1][0] = 1;
                mImageButton4.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.five:
                mImageButton5.setImageDrawable(getDrawable(R.drawable.cris));
                field[1][1] = 1;
                mImageButton5.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.six:
                mImageButton6.setImageDrawable(getDrawable(R.drawable.cris));
                field[0][2] = 1;
                mImageButton6.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.seven:
                mImageButton7.setImageDrawable(getDrawable(R.drawable.cris));
                field[2][0] = 1;
                mImageButton7.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.eight:
                mImageButton8.setImageDrawable(getDrawable(R.drawable.cris));
                field[0][1] = 1;
                mImageButton8.setEnabled(false);
                checkWinn();
                nextMove();
                break;
            case R.id.nine:
                mImageButton9.setImageDrawable(getDrawable(R.drawable.cris));
                field[0][2] = 1;
                mImageButton9.setEnabled(false);
                checkWinn();
                nextMove();
                break;
        }
    }


    private void nextMove() {
        Random randNumber = new Random();
        int i = randNumber.nextInt(3);
        int j = randNumber.nextInt(3);

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
            nextMove();
        }

    }

    private void checkWinn() {

        if (field[0][0] == 1 && field[0][1] == 1 && field[0][2] == 1) {
            mWinner.setText("Выйграли Крестики!");
        }
        if (field[1][0] == 1 && field[1][1] == 1 && field[1][2] == 1) {
            mWinner.setText("Выйграли Крестики!");
        }
        if (field[2][0] == 1 && field[2][1] == 1 && field[2][2] == 1) {
            mWinner.setText("Выйграли Крестики!");
        }
        if (field[0][0] == 1 && field[1][0] == 1 && field[2][0] == 1) {
            mWinner.setText("Выйграли Крестики!");
        }
        if (field[0][1] == 1 && field[1][1] == 1 && field[2][1] == 1) {
            mWinner.setText("Выйграли Крестики!");
        }
        if (field[0][2] == 1 && field[1][2] == 1 && field[2][2] == 1) {
            mWinner.setText("Выйграли Крестики!");
        }
        if (field[0][0] == 1 && field[1][1] == 1 && field[2][2] == 1) {
            mWinner.setText("Выйграли Крестики!");
        }
        if (field[0][2] == 1 && field[1][1] == 1 && field[2][0] == 1) {
            mWinner.setText("Выйграли Крестики!");
        }

        if (field[0][0] == 0 && field[0][1] == 0 && field[0][2] == 0) {
            mWinner.setText("Выйграли Нолики!");
        }
        if (field[1][0] == 0 && field[1][1] == 0 && field[1][2] == 0) {
            mWinner.setText("Выйграли Нолики!");
        }
        if (field[2][0] == 0 && field[2][1] == 0 && field[2][2] == 0) {
            mWinner.setText("Выйграли Нолики!");
        }
        if (field[0][0] == 0 && field[1][0] == 0 && field[2][0] == 0) {
            mWinner.setText("Выйграли Нолики!");
        }
        if (field[0][1] == 0 && field[1][1] == 0 && field[2][1] == 1) {
            mWinner.setText("Выйграли Нолики!");
        }
        if (field[0][2] == 0 && field[1][2] == 0 && field[2][2] == 0) {
            mWinner.setText("Выйграли Нолики!");
        }
        if (field[0][0] == 0 && field[1][1] == 0 && field[2][2] == 0) {
            mWinner.setText("Выйграли Нолики!");
        }
        if (field[0][2] == 0 && field[1][1] == 0 && field[2][0] == 0) {
            mWinner.setText("Выйграли Нолики!");
        }
//        int hor1 = 0;
//        int ver1 = 0;
//        int hor0 = 0;
//        int ver0 = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (field[i][j] == 1) {
//                    hor1++;
//                }
//                if (field[j][i] == 1) {
//                    ver1++;
//                }
//                if (field[i][j] == 0) {
//                    hor0++;
//                }
//                if (field[j][i] == 0) {
//                    ver0++;
//                }
//            }
//            if (hor1 == 3 || ver1 == 3) {
//                mWinner.setText("Выйграли Крестики!");
//            }
//            if (hor0 == 3 || ver0 == 3) {
//                mWinner.setText("Выйграли Нолики!");
//            }
    }
}



