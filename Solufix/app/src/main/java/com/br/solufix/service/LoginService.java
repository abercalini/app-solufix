package com.br.solufix.service;

import com.br.solufix.model.ResponseEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {

    @Headers({"Authorization: Basic YW5ndWxhcjphbmd1bGFy", "Content-Type: application/x-www-form-urlencoded"})
    @FormUrlEncoded
    @POST("oauth/token")
    Call<ResponseEntity> logar(@Field("username") String email,
                               @Field("password") String senha,
                               @Field("grant_type") String grant_type);

}
