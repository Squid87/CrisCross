package com.example.tie.criscros;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.tie.criscros.authorization.mvp.AuthorizationPresenter;
import com.example.tie.criscros.authorization.mvp.AuthorizationView;
import com.example.tie.criscros.game.GameActivity;
import com.example.tie.criscros.registration.RegistrationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends MvpAppCompatActivity implements AuthorizationView {
    private String login;
    private String password;

    @InjectPresenter
    AuthorizationPresenter mAuthorizationPresenter;

    @BindView(R.id.button_enter)
    Button mButtonEnter;

    @BindView(R.id.button_registration)
    Button mButtonRegistration;

    @BindView(R.id.edit_text_login)
    EditText mLogin;

    @BindView(R.id.edit_text_password)
    EditText mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButtonEnter.setOnClickListener(v -> startGame("cris"));
        mButtonRegistration.setOnClickListener(v -> registration());

    }

    private void registration() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void startGame(String s) {
        if (mLogin.getText().toString().trim().isEmpty()) {
            mLogin.setError("Введите логин");
            return;
        }
        if (mPassword.getText().toString().trim().isEmpty()) {
            mPassword.setError("Введите пароль");
            return;
        }
        login = mLogin.getText().toString();
        password = mPassword.getText().toString();
        mAuthorizationPresenter.auth(login, password);

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void success() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Good!!!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public void error(String error) {
        Toast toast = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
