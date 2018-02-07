package com.example.tie.criscros.network;


import com.example.tie.criscros.authorization.AuthorizationBody;
import com.example.tie.criscros.authorization.model.AuthorizationResponse;
import com.example.tie.criscros.registration.RegistrationBody;
import com.example.tie.criscros.registration.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/api/reg")
    Call<RegistrationResponse> getRegistration(@Body RegistrationBody body);

    @POST("/api/auth")
    Call<AuthorizationResponse> getAuth(@Body AuthorizationBody body);


}
