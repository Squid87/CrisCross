package com.example.tie.criscros.authorization.mvp;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.tie.criscros.Application;
import com.example.tie.criscros.authorization.AuthorizationBody;
import com.example.tie.criscros.authorization.model.AuthorizationResponse;
import com.example.tie.criscros.network.ApiService;

import java.io.IOException;

import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class AuthorizationPresenter extends MvpPresenter<AuthorizationView> {
    private String BASE_URL = "http://ushmodin.ru:8080/";
    private ApiService mApiService = ApiService.getsInstance(Application.getInstance(), BASE_URL);
    private String username;
    private String password;

    public void auth(String username, String password) {
        this.username = username;
        this.password = password;
        rx.Observable.fromCallable(this::requestAuthorization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<AuthorizationResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<AuthorizationResponse> response) {
                        AuthorizationResponse respons = response.body();
                        getViewState().success();

                    }
                });
    }

    private Response<AuthorizationResponse> requestAuthorization() throws IOException {
        AuthorizationBody authBody = new AuthorizationBody();
        authBody.setPassword(password);
        authBody.setLogin(username);
        return mApiService.createApi().getAuth(authBody).execute();
    }
}
