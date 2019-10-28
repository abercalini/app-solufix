package com.br.solufix.sync;

import com.br.solufix.response.ProdutoResponse;

import java.util.List;

public class ProdutoSync {

    private List<ProdutoResponse> content;
    private int totalElements;
    private int totalPages;
    private boolean last;
    private int size;
    private int number;
    private String sort;
    private int numberOfElements;
    private boolean first;

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public List<ProdutoResponse> getContent() {
        return content;
    }



    public void setContent(List<ProdutoResponse> content) {
        this.content = content;
    }
}
