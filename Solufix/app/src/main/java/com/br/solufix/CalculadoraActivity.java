package com.br.solufix;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    private EditText comprimento;
    private TextView valorComprimento;
    private TextView multiplicar;

    private EditText campoLargura;
    private TextView valorLargura;
    private TextView multiplicarAux;

    private EditText campoProfundidade;
    private TextView valorProfundidade;

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);



        comprimento = findViewById(R.id.calculador_comprimento);
        valorComprimento = findViewById(R.id.valor_comprimento);
        multiplicar = findViewById(R.id.multiplicar);
       comprimento.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

           @Override
           public void afterTextChanged(Editable editable) {
               valorComprimento.setText(comprimento.getText().toString());
           }
       });

        campoLargura = findViewById(R.id.calculador_largura);
        valorLargura = findViewById(R.id.valor_largura);
        campoLargura.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                multiplicar.setText("*");
                valorLargura.setText(campoLargura.getText().toString());
            }
        });


        campoProfundidade = findViewById(R.id.calculador_profundidade);
        valorProfundidade = findViewById(R.id.valor_profundidade);
        multiplicarAux = findViewById(R.id.multiplicarAux);
        resultado = findViewById(R.id.calculadora_resultado);
        campoProfundidade.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                multiplicarAux.setText("*");
                valorProfundidade.setText(campoProfundidade.getText().toString());

                Double valorComprimentoAux = Double.valueOf(comprimento.getText().toString());
                Double valorLarguraAux = Double.valueOf(campoLargura.getText().toString());
                Double valorProfundidadeAux = Double.valueOf(campoProfundidade.getText().toString());
                Double valorTotal = valorComprimentoAux * valorLarguraAux * valorProfundidadeAux;

                resultado.setText("Resultado = " + String.valueOf(valorTotal));
            }
        });

    }

}
