package org.example;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Iniciando criação do arquivo");

    File arquivo = new File("C:/projetos/arquivo.txt");

    try {
      arquivo.createNewFile();
      FileWriter escritor = new FileWriter(arquivo);
      BufferedWriter buffer = new BufferedWriter(escritor);
      // Escrever o texto
      buffer.write("Teste1");
      buffer.write("Teste2");
      buffer.newLine();
      buffer.newLine();
      buffer.write("Teste3");
      // Fechar o fluxo
      buffer.close();

      System.out.print("Arquivo criado com sucesso!");
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao gerar o arquivo");
      e.printStackTrace();
    }

  }
}