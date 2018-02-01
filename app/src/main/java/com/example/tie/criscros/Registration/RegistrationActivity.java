package com.example.tie.criscros.Registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.tie.criscros.MainActivity;
import com.example.tie.criscros.R;
import com.example.tie.criscros.Registration.MVP.RegistrationPresenter;
import com.example.tie.criscros.Registration.MVP.RegistrationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends MvpAppCompatActivity implements RegistrationView{
    @InjectPresenter
    RegistrationPresenter mRegistrationPresenter;

    private Vibrator vib;
    private String login;
    private String password;
    private String mail;

    @BindView(R.id.button_back)
    Button mButtonBack;

    @BindView(R.id.button_registrate)
    Button mButtonRegistrate;

    @BindView(R.id.edit_text_registration_login)
    EditText mLogin;

    @BindView(R.id.edit_text_registration_password)
    EditText mPassword;

    @BindView(R.id.edit_text_registration_email)
    EditText mMail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        mButtonBack.setOnClickListener(view -> back());
        mButtonRegistrate.setOnClickListener(view -> registrate());

        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    private void registrate() {
        if (mLogin.getText().toString().trim().isEmpty()) {
            vib.vibrate(120);
            mLogin.setError("Введите логин");
            return;
        }
        if (mPassword.getText().toString().trim().isEmpty()) {
            vib.vibrate(120);
            mPassword.setError("Введите пароль");
            return;
        }
        if (mMail.getText().toString().trim().isEmpty()) {
            vib.vibrate(120);
            mMail.setError("Введите почту");
            return;
        }
        login = mLogin.getText().toString();
        password = mPassword.getText().toString();
        mail = mMail.getText().toString();
        mRegistrationPresenter.signUp(login,password,mail);

    }

    private void back() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
