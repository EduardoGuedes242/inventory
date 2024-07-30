package org.example.service.product;

import org.example.entity.product.Product;
import org.example.infra.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

  public boolean cadastrarProduto(String name, double price, double quantidadeEstoque) {
    String sqlInsert = """
            INSERT INTO JAVA$PRODUTOS (descricao, quantidadeEstoque, valor)
            VALUES
              (?, ?, ?)
            """;
    try(Connection conexao = ConnectionDB.getConneciton();
        PreparedStatement pstmt = conexao.prepareStatement(sqlInsert);)
    {
      pstmt.setString(1, name);
      pstmt.setDouble(2, quantidadeEstoque);
      pstmt.setDouble(3, price);

      pstmt.executeUpdate();
    }  catch (SQLException e) {
      System.out.println("Erro ao cadastrar produto: " + e.getMessage());
      return false;
    }
    return true;
  }

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
