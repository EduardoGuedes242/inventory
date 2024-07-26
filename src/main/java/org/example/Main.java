package org.example;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.entity.product.Product;
import org.example.service.product.ProductService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Iniciando criação do arquivo");

    ProductService productService = new ProductService();
    File arquivo = new File("C:/projetos/arquivo.txt");


    try {
      Reader reader = Files.newBufferedReader(Paths.get("C:/projetos/arquivo.txt"));
      CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

      List<String[]> linhaCompleta = csvReader.readAll();
      for (String[] linha : linhaCompleta) {
        System.out.println("Lendo arquivos: " + linha[0]);
      }
    } catch (IOException e) {
      System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
    }



    try {
      arquivo.createNewFile();
      FileWriter escritor = new FileWriter(arquivo);
      BufferedWriter buffer = new BufferedWriter(escritor);

      List<Product> listaProdutos =  productService.getAllProducts();



      for(Product product : listaProdutos) {
        System.out.println("Lendo produtos.....");
        buffer.write(product.getIdentificadorProdudo());
        buffer.write(";");
        buffer.write(product.getDescricao());
        buffer.newLine();
      }

      buffer.close();

      System.out.print("Arquivo criado com sucesso!");
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao gerar o arquivo");
      e.printStackTrace();
    }

  }
}