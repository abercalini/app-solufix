package com.br.solufix;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.br.solufix.adapter.ProdutoItemAdapter;
import com.br.solufix.response.ProdutoResponse;
import com.br.solufix.retrofit.RetrofitCondfig;
import com.br.solufix.service.ProdutoService;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdutoActivity extends AppCompatActivity {

    private EditText produtoFiltro;
    private String token;
    private ListView listaProdutos;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_produto);

        token = getIntent().getStringExtra("token");
        produtoFiltro = findViewById(R.id.filtro_produto);
        listaProdutos = findViewById(R.id.lista_item_produto);


        Button botaoFiltro = findViewById(R.id.filtro_botao);
        botaoFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress = new ProgressDialog(ProdutoActivity.this);
                progress.setMessage("Carregando");
                progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.setIndeterminate(true);
                progress.setProgress(20);
                progress.show();
                RetrofitCondfig config = new RetrofitCondfig();
                Call<List<ProdutoResponse>> call = config.getProdutos().listarParametro("Bearer " + token, produtoFiltro.getText().toString());
                call.enqueue(new Callback<List<ProdutoResponse>>() {
                    @Override
                    public void onResponse(Call<List<ProdutoResponse>> call, Response<List<ProdutoResponse>> response) {
                        List<ProdutoResponse> produtoResponse = response.body();
                        if (produtoResponse == null || produtoResponse.isEmpty()) {
                                Toast.makeText(ProdutoActivity.this, "Nenhum produto com esse nome", Toast.LENGTH_SHORT).show();
                            produtoFiltro.setText("");
                            progress.cancel();
                        } else {
                            progress.setProgress(100);
                            progress.cancel();
                            ProdutoItemAdapter adapter = new ProdutoItemAdapter(ProdutoActivity.this, produtoResponse);
                            listaProdutos.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ProdutoResponse>> call, Throwable t) {
                        progress.cancel();
                        Toast.makeText(ProdutoActivity.this, "Falha", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

}
