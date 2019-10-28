package com.br.solufix.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class ProdutoResponse {

    private Long codigo;
    private String nome;
    private String descricao;

    private String codigoBarra;
    private String observacao;

    private BigDecimal valor;

    private String caminhoFoto;

    @JsonProperty("estoque")
    private EstoqueResponse estoqueResponse;

    @JsonProperty("categoria")
    private CategoriaResponse categoriaResponse;


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EstoqueResponse getEstoqueResponse() {
        return estoqueResponse;
    }

    public void setEstoqueResponse(EstoqueResponse estoqueResponse) {
        this.estoqueResponse = estoqueResponse;
    }

    public CategoriaResponse getCategoriaResponse() {
        return categoriaResponse;
    }

    public void setCategoriaResponse(CategoriaResponse categoriaResponse) {
        this.categoriaResponse = categoriaResponse;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    @Override
    public String toString() {
        return "ProdutoResponse{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", codigoBarra='" + codigoBarra + '\'' +
                ", observacao='" + observacao + '\'' +
                ", valor=" + valor +
                ", caminhoFoto='" + caminhoFoto + '\'' +
                ", estoqueResponse=" + estoqueResponse +
                ", categoriaResponse=" + categoriaResponse +
                '}';
    }
}
