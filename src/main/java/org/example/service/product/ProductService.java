package org.example.service.product;

import org.example.entity.product.Product;
import org.example.infra.database.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();
    try (Connection conexao = ConnectionDB.getConneciton();
         ResultSet resultUsers = conexao.createStatement().executeQuery("SELECT * FROM JAVA$PRODUTOS")
    )
    {
      while (resultUsers.next()) {
        String identificadoUnico = resultUsers.getString("id");
        String descricaoProduto = resultUsers.getString("descricao");
        double estoque = resultUsers.getDouble("quantidadeestoque");
        double preco = resultUsers.getDouble("valor");

        products.add(new Product(identificadoUnico, descricaoProduto, estoque, preco));
      }
    } catch (SQLException e) {
      System.out.println("Erro ao buscar usuarios: " + e.getMessage());
    }
    return products;
  }

}
