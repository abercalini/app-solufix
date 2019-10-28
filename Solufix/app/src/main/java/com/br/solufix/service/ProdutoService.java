package com.br.solufix.service;

import com.br.solufix.response.ProdutoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ProdutoService {

    @GET("produtos/android")
    Call<List<ProdutoResponse>> listarProdutos(@Header("Authorization") String bearer);


}
