package com.br.solufix.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.br.solufix.ProdutoActivity;
import com.br.solufix.R;
import com.br.solufix.response.ProdutoResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ProdutoItemAdapter extends BaseAdapter {

    private final List<ProdutoResponse> produtos;
    private final Context context;

    public ProdutoItemAdapter(Context context, List<ProdutoResponse> produtoResponse) {
        this.context = context;
        this.produtos = produtoResponse;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int i) {
        return produtos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return produtos.get(i).getCodigo();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ProdutoResponse produto = produtos.get(i);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if(convertView == null) {
            view = inflater.inflate(R.layout.menu_item_produto, parent, false);
        }

        TextView campoNome = view.findViewById(R.id.produto_item_nome);
        campoNome.setText(produto.getNome());
        TextView campoDescricao = view.findViewById(R.id.produto_item_descricao);
        campoDescricao.setText("Descricao: " + produto.getDescricao());
        TextView campoQuantidade = view.findViewById(R.id.produto_item_quantidade);
        campoQuantidade.setText("Quantidade: " + produto.getEstoqueResponse().getQuantidade());
        TextView campoValor = view.findViewById(R.id.produto_item_valor);
        campoValor.setText("Valor:" + produto.getValor() + "R$");

        SimpleDraweeView imagem = view.findViewById(R.id.produto_item_foto);
        Uri uri = Uri.parse(produto.getCaminhoFoto());
        imagem.setImageURI(uri);
        return view;
    }
}
