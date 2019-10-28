package com.br.solufix.response;

public class EstoqueResponse {

    private Long codigo;
    private int quantidade;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "EstoqueResponse{" +
                "codigo=" + codigo +
                ", quantidade=" + quantidade +
                '}';
    }
}
