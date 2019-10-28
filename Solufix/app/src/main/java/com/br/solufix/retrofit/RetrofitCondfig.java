package com.br.solufix.retrofit;

import com.br.solufix.service.CepService;
import com.br.solufix.service.LoginService;
import com.br.solufix.service.ProdutoService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitCondfig {

    private Retrofit retrofit;
    private String token;



    public RetrofitCondfig() {
        //http://10.0.0.6:8080/
        //https://solufix.herokuapp.com/
        this.retrofit = new Retrofit.Builder().baseUrl("https://solufix-api.herokuapp.com/")
            .addConverterFactory(JacksonConverterFactory.create()).build();
    }




    public LoginService getLogin() {
        return this.retrofit.create(LoginService.class);
    }
    public ProdutoService getProdutos() {

        return this.retrofit.create(ProdutoService.class);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
