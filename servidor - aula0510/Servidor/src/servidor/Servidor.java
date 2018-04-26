/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author Alunotgn
 */
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta!");

        Socket /*fluco de comunicação*/ cliente /*obejeto associado ao fluxo*/ = servidor.accept();
        System.out.println("Nova conexão com o cliente "
                + cliente.getInetAddress().getHostAddress());

        Scanner entrada = new Scanner(cliente.getInputStream());//trabalha com o que foi recebido do canal de comunicação cliente
        
        PrintStream saida = new PrintStream(cliente.getOutputStream());//trabalha em responder o cliente 

        while (entrada.hasNextLine()) {
            String a = entrada.nextLine();
            if (a.equals("teste")) {
                saida.println("AAAAAAAAAAA");//imprime caso a mensagem seja correspondente
            } else {
                saida.println("não deu ein");
            }
            //System.out.println(entrada.nextLine());
        }
        entrada.close();
        servidor.close();
    }
}
