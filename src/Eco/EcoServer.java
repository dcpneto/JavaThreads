package Eco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author djalmaneto
 */
public class EcoServer {

    public static void main(String args[]) {
        try {
            ServerSocket s = new ServerSocket(35000);
            while (true) {
                System.out.print("Aguardando conexão...");
                Socket conexao = s.accept();
                System.out.println(" - Conectado");
                BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                PrintStream saida = new PrintStream(conexao.getOutputStream());
                String linha = entrada.readLine();
                while (linha != null && !(linha.trim().equals(""))) {
                    saida.println(Inet4Address.getLocalHost().getHostAddress() + linha);
                    linha = entrada.readLine();
                }
                conexao.close();
            }
        } catch (IOException e) {
            System.out.println("Erro - " + e);
        }
    }
}
