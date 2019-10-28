package com.br.solufix.service;

import com.br.solufix.model.Cep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {

    @GET("ws/{cep}/json/")
    Call<Cep> buscarCep(@Path("cep") String cep);

}

