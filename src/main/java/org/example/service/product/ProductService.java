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
        String identificadoUnico = resultUsers.getString("pro_codigo");
        String descricaoProduto = resultUsers.getString("pro_codigo");
        double estoque = resultUsers.getDouble("pro_estoque");
        double preco = resultUsers.getDouble("pro_preco");
        ;

        products.add(new Product(identificadoUnico, descricaoProduto, estoque, preco));
      }
    } catch (SQLException e) {
      System.out.println("Erro ao buscar usuarios: " + e.getMessage());
    }
    return products;
  }


}
