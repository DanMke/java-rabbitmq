package com.orderservice.createorder.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
  @JsonProperty
  private Integer codigoPedido;
  @JsonProperty
  private Integer codigoCliente;
  @JsonProperty
  private Item[] itens;

  public Order() {
  }

  public Order(Integer codigoPedido, Integer codigoCliente, Item[] itens) {
    this.codigoPedido = codigoPedido;
    this.codigoCliente = codigoCliente;
    this.itens = itens;
  }

  public Integer getCodigoPedido() {
    return codigoPedido;
  }

  public void setCodigoPedido(Integer codigoPedido) {
    this.codigoPedido = codigoPedido;
  }

  public Integer getCodigoCliente() {
    return codigoCliente;
  }

  public void setCodigoCliente(Integer codigoCliente) {
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
