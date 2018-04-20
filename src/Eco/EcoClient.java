package Eco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author djalmaneto
 */
public class EcoClient {

    public static void main(String args[]) {
        try {
            Socket conexao = new Socket("127.0.0.1", 35000);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            PrintStream saida = new PrintStream(conexao.getOutputStream());

            String linha;
            BufferedReader teclado
                    = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("> ");
                linha = teclado.readLine();
                saida.println(linha);
                linha = entrada.readLine();
                if (linha == null) {
                    System.out.println("Conexão encerrada.");
                    break;
                }
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro - " + e);
        }
    }

}
