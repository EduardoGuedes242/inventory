package org.example.entity.product;

public class Product {
  private String identificadorProdudo;
  private String descricao;
  private double quantidadeEstoque;
  private double valor;

  public Product(String identificadorProdudo, String descricao, double quantidadeEstoque, double valor) {
    this.identificadorProdudo = identificadorProdudo;
    this.descricao = descricao;
    this.quantidadeEstoque = quantidadeEstoque;
    this.valor = valor;
  }

  public String getIdentificadorProdudo() {
    return identificadorProdudo;
  }
  public void setIdentificadorProdudo(String identificadorProdudo) {
    this.identificadorProdudo = identificadorProdudo;
  }

  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getQuantidadeEstoque() {
    return quantidadeEstoque;
  }
  public void setQuantidadeEstoque(double quantidadeEstoque) {
    this.quantidadeEstoque = quantidadeEstoque;
  }

  public double getValor() {
    return valor;
  }
  public void setValor(double valor) {
    this.valor = valor;
  }
}
