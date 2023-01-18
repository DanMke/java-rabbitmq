package com.orderservice.saveorder.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
  @JsonProperty("codigoPedido")
  private int codigoPedido;
  @JsonProperty("codigoCliente")
  private int codigoCliente;
  @JsonProperty("itens")
  private Item[] itens;

  public Order() {
  }

  public Order(int codigoPedido, int codigoCliente, Item[] itens) {
    this.codigoPedido = codigoPedido;
    this.codigoCliente = codigoCliente;
    this.itens = itens;
  }

  public int getCodigoPedido() {
    return codigoPedido;
  }

  public void setCodigoPedido(int codigoPedido) {
    this.codigoPedido = codigoPedido;
  }

  public int getCodigoCliente() {
    return codigoCliente;
  }

  public void setCodigoCliente(int codigoCliente) {
    this.codigoCliente = codigoCliente;
  }

  public Item[] getItens() {
    return itens;
  }

  public void setItens(Item[] itens) {
    this.itens = itens;
  }

  @Override
  public String toString() {
    return
      "Order{" +
        "codigoPedido=" + codigoPedido +
        ", codigoCliente=" + codigoCliente +
        ", itens=" + Arrays.toString(itens) +
        '}';
  }
}
