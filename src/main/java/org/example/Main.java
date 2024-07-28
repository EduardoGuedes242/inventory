package org.example;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.entity.product.Product;
import org.example.service.product.ProductService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
  ProductService productService = new ProductService();

  public void criandoArquivo() {
    File arquivo = new File("C:/projetos/arquivo.txt");
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


  public static void main(String[] args) {
    ProductService productService = new ProductService();
    System.out.println("Iniciando o programa...");
    Scanner scanner = new Scanner(System.in);
    int opcao = scanner.nextInt();

    if(opcao == 1) {
      try {
        Reader reader = Files.newBufferedReader(Paths.get("C:/projetos/arquivo.txt"));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        String str = "I love Java";
        String[] words = str.split(" ");

        List<String[]> linhaCompleta = csvReader.readAll();
        for (String[] linha : linhaCompleta) {
          String[] dadosProduto = linha[0].split(";");

          productService.cadastrarProduto(dadosProduto[1], 0, 0);
          //System.out.println("Dados " + dadosProduto[1]);
        }
      } catch (IOException e) {
        System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
      }
    }

  }
}