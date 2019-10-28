package com.br.solufix.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.br.solufix.R;
import com.br.solufix.response.ProdutoResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import retrofit2.Callback;

public class ProdutoAdapter extends BaseAdapter {


    private final Context context;
    private final List<ProdutoResponse> produtos;

    public ProdutoAdapter(Context context, List<ProdutoResponse> produtos) {
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produtos.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProdutoResponse produto = produtos.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if(convertView == null) {
            view = inflater.inflate(R.layout.menu_item, parent, false);
        }

        TextView campoNome = view.findViewById(R.id.item_nome);
        campoNome.setText(produto.getNome());
        TextView campoDescricao = view.findViewById(R.id.item_descricao);
        campoDescricao.setText("Descricao: " + produto.getDescricao());
        TextView campoQuantidade = view.findViewById(R.id.item_quantidade);
        campoQuantidade.setText("Quantidade: " + produto.getEstoqueResponse().getQuantidade());
        TextView campoValor = view.findViewById(R.id.item_valor);
        campoValor.setText("Valor:" + produto.getValor() + "R$");

        SimpleDraweeView imagem = view.findViewById(R.id.item_foto);
        Uri uri = Uri.parse(produto.getCaminhoFoto());
        imagem.setImageURI(uri);
        return view;
    }
}
