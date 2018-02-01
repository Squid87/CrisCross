package com.example.tie.criscros.Game;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.tie.criscros.MainActivity;
import com.example.tie.criscros.R;

import java.util.Objects;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GameActivity extends MvpAppCompatActivity implements View.OnClickListener, GameView {

    @InjectPresenter
    GamePresenter mGamePresenter;

    @BindView(R.id.one)
    ImageButton mImageButton1;
    @BindView(R.id.two)
    ImageButton mImageButton2;
    @BindView(R.id.three)
    ImageButton mImageButton3;
    @BindView(R.id.four)
    ImageButton mImageButton4;
    @BindView(R.id.five)
    ImageButton mImageButton5;
    @BindView(R.id.six)
    ImageButton mImageButton6;
    @BindView(R.id.seven)
    ImageButton mImageButton7;
    @BindView(R.id.eight)
    ImageButton mImageButton8;
    @BindView(R.id.nine)
    ImageButton mImageButton9;
    @BindView(R.id.new_game)
    Button mButtonNewGame;
    @BindView(R.id.winner_text_view)
    TextView mWinner;


    public String crisOrCross;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initBind();

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

        mButtonNewGame.setOnClickListener(view -> {
            Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent1);
        });
    }

    private void initBind() {
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.one:
                mGamePresenter.move(crisOrCross, 0, 0);
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton1.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton1.setEnabled(false);
                    break;
                }
                mImageButton1.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton1.setEnabled(false);
                break;
            case R.id.two:
                mGamePresenter.move(crisOrCross, 0, 1);
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton2.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton2.setEnabled(false);
                    break;
                }
                mImageButton2.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton2.setEnabled(false);
                break;
            case R.id.three:
                mGamePresenter.move(crisOrCross, 0, 2);
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton3.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton3.setEnabled(false);
                    break;
                }
                mImageButton3.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton3.setEnabled(false);
                break;
            case R.id.four:
                mGamePresenter.move(crisOrCross, 1, 0);
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton4.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton4.setEnabled(false);
                    break;
                }
                mImageButton4.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton4.setEnabled(false);
                break;
            case R.id.five:
                mGamePresenter.move(crisOrCross, 1, 1);
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton5.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton5.setEnabled(false);
                    break;
                }
                mImageButton5.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton5.setEnabled(false);
                break;
            case R.id.six:
                mGamePresenter.move(crisOrCross, 1, 2);
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton6.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton6.setEnabled(false);
                    break;
                }
                mImageButton6.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton6.setEnabled(false);
                break;
            case R.id.seven:
                mGamePresenter.move(crisOrCross, 2, 0);
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton7.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton7.setEnabled(false);
                    break;
                }
                mImageButton7.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton7.setEnabled(false);
                break;
            case R.id.eight:
                mGamePresenter.move(crisOrCross, 2, 1);
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton8.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton8.setEnabled(false);
                    break;
                }
                mImageButton8.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton8.setEnabled(false);
                break;
            case R.id.nine:
                mGamePresenter.move(crisOrCross, 2, 2);
                if (Objects.equals(crisOrCross, "cross")) {
                    mImageButton9.setImageDrawable(getDrawable(R.drawable.cros));
                    mImageButton9.setEnabled(false);
                    break;
                }
                mImageButton9.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton9.setEnabled(false);
                break;
            case R.id.new_game:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void nextMove(String s, int i, int j) {
        if (Objects.equals(s, "cris")) {
            if (i == 0 && j == 0) {
                mImageButton1.setImageDrawable(getDrawable(R.drawable.cros));
                mImageButton1.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 0 && j == 1) {
                mImageButton2.setImageDrawable(getDrawable(R.drawable.cros));
                mImageButton2.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 0 && j == 2) {
                mImageButton3.setImageDrawable(getDrawable(R.drawable.cros));
                mImageButton3.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 1 && j == 0) {
                mImageButton4.setImageDrawable(getDrawable(R.drawable.cros));
                mImageButton4.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 1 && j == 1) {
                mImageButton5.setImageDrawable(getDrawable(R.drawable.cros));
                mImageButton5.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 1 && j == 2) {
                mImageButton6.setImageDrawable(getDrawable(R.drawable.cros));
                mImageButton6.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 2 && j == 0) {
                mImageButton7.setImageDrawable(getDrawable(R.drawable.cros));
                mImageButton7.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 2 && j == 1) {
                mImageButton8.setImageDrawable(getDrawable(R.drawable.cros));
                mImageButton8.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 2 && j == 2) {
                mImageButton9.setImageDrawable(getDrawable(R.drawable.cros));
                mImageButton9.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
        }
        if (Objects.equals(s, "cross")) {
            if (i == 0 && j == 0) {
                mImageButton1.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton1.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 0 && j == 1) {
                mImageButton2.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton2.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 0 && j == 2) {
                mImageButton3.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton3.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 1 && j == 0) {
                mImageButton4.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton4.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 1 && j == 1) {
                mImageButton5.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton5.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 1 && j == 2) {
                mImageButton6.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton6.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 2 && j == 0) {
                mImageButton7.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton7.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 2 && j == 1) {
                mImageButton8.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton8.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
            if (i == 2 && j == 2) {
                mImageButton9.setImageDrawable(getDrawable(R.drawable.cris));
                mImageButton9.setEnabled(false);
                mGamePresenter.checkWin();
                return;
            }
        }
    }

    @Override
    public void checkWin(String s) {
        mWinner.setText(s);
    }

    @Override
    public void disableField() {
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

}


