package com.orderservice.saveorder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
  @JsonProperty("produto")
  private String produto;
  @JsonProperty("quantidade")
  private int quantidade;
  @JsonProperty("preco")
  private double preco;

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
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
