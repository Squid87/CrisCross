package com.example.tie.criscros.registration.mvp;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.tie.criscros.Application;
import com.example.tie.criscros.network.ApiService;
import com.example.tie.criscros.registration.RegistrationBody;
import com.example.tie.criscros.registration.model.RegistrationResponse;

import java.io.IOException;

import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


@InjectViewState
public class RegistrationPresenter extends MvpPresenter<RegistrationView> {

    private String BASE_URL = "http://ushmodin.ru:8080/";
    private ApiService mApiService = ApiService.getsInstance(Application.getInstance(), BASE_URL);
    private String username;
    private String password;
    private String mail;

    public void signUp(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        rx.Observable.fromCallable(this::requestRegistration)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<RegistrationResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<RegistrationResponse> response) {
                        if (response.code() == 200) {
                            getViewState().success();
                            getViewState().mainMenu();
                        }
                        if (response.code() == 403) {
                            try {
                                getViewState().error(response.errorBody().string().substring(31,54));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    private Response<RegistrationResponse> requestRegistration() throws IOException {
        RegistrationBody body = new RegistrationBody();
        body.setMail(mail);
        body.setPassword(password);
        body.setLogin(username);
        return mApiService.createApi().getRegistration(body).execute();
    }
}
