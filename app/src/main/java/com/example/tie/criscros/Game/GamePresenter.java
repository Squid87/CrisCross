package com.example.tie.criscros.Game;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Objects;
import java.util.Random;

@InjectViewState
public class GamePresenter extends MvpPresenter<GameView> {

    private int[][] field = new int[3][3];

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = 2;
            }
        }
    }

    public void move(String s, int i, int j) {
        checkWin();
        if (Objects.equals(s, "cris")) {
            for (int k = 0; k < 3; k++) {
                for (int t = 0; t < 3; t++) {
                    if (i == k && j == t) {
                        field[k][t] = 1;
                    }
                }
            }
            checkWin();
            nextMove(s);
        }
        if (Objects.equals(s, "cross")) {
            for (int k = 0; k < 3; k++) {
                for (int t = 0; t < 3; t++) {
                    if (i == k && j == t) {
                        field[k][t] = 0;
                    }
                }
            }
            checkWin();
            nextMove(s);
        }
    }

    public void nextMove(String s) {
        checkWin();
        Random randNumber = new Random();
        int i = randNumber.nextInt(3);
        int j = randNumber.nextInt(3);

        if (Objects.equals(s, "cris")) {
            if (field[i][j] == 2) {
                field[i][j] = 0;
                getViewState().nextMove(s, i, j);
            }
        }

        if (Objects.equals(s, "cross")) {
            if (field[i][j] == 2) {
                field[i][j] = 1;
                getViewState().nextMove(s, i, j);
            }
        }
    }

    public void checkWin() {
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
                getViewState().checkWin("Выйграли Крестики!");
                getViewState().disableField();
            }
            if (hor0 == 3 || ver0 == 3) {
                getViewState().checkWin("Выйграли Нолики!");
                getViewState().disableField();
            }
        }

        int mDig1 = 0;
        int mSupDig1 = 0;
        int mDig0 = 0;
        int mSupDig0 = 0;

        for (int i = 0; i < 3; i++) {
            if (field[i][i] == 1) {
                mDig1++;
            }
            if (field[i][i] == 0) {
                mDig0++;
            }
            if (field[i][2 - i] == 1) {
                mSupDig1++;
            }
            if (field[i][2 - i] == 0) {
                mSupDig0++;
            }
        }
        if (mDig1 == 3 || mSupDig1 == 3) {
            getViewState().checkWin("Выйграли Крестики!");
            getViewState().disableField();
        }
        if (mDig0 == 3 || mSupDig0 == 3) {
            getViewState().checkWin("Выйграли Нолики!");
            getViewState().disableField();
        }

    }
}
