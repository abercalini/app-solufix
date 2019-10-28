package com.br.solufix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.br.solufix.adapter.ProdutoAdapter;
import com.br.solufix.response.ProdutoResponse;
import com.br.solufix.retrofit.RetrofitCondfig;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdutosActivity extends AppCompatActivity {

    ProdutoAdapter adapter;
    ListView listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_produtos);
        listaProdutos = findViewById(R.id.lista_produtos);

        Intent intent = getIntent();
        String token = intent.getStringExtra("token");

        Call<List<ProdutoResponse>> call = new RetrofitCondfig().getProdutos().listarProdutos("Bearer " + token);
        call.enqueue(new Callback<List<ProdutoResponse>>() {
            @Override
            public void onResponse(Call<List<ProdutoResponse>> call, Response<List<ProdutoResponse>> response) {
                List<ProdutoResponse> produtos = response.body();

            adapter = new ProdutoAdapter(ProdutosActivity.this, produtos);
            listaProdutos.setAdapter(adapter);

                Log.d("sucesso", produtos.toString());
                Toast.makeText(ProdutosActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ProdutoResponse>> call, Throwable t) {
                Log.e("error", t.getMessage());
                Toast.makeText(ProdutosActivity.this, "Falha", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
