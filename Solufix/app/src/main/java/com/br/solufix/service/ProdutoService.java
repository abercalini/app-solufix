package com.br.solufix.service;

import com.br.solufix.response.ProdutoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ProdutoService {

    @GET("produtos/android")
    Call<List<ProdutoResponse>> listarProdutos(@Header("Authorization") String bearer);

    @GET("produtos/android")
    Call<List<ProdutoResponse>> listarParametro(@Header("Authorization") String bearer, @Query("nome") String nome);

}
