package com.orderservice.createorder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
  @JsonProperty
  private String produto;
  @JsonProperty
  private Integer quantidade;
  @JsonProperty
  private Double preco;

  public Item() {
  }

  public Item(String produto, Integer quantidade, Double preco) {
    this.produto = produto;
    this.quantidade = quantidade;
    this.preco = preco;
  }

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  @Override
  public String toString() {
    return "Item{" +
      "produto='" + produto + '\'' +
      ", quantidade=" + quantidade +
      ", preco=" + preco +
      '}';
  }
}
