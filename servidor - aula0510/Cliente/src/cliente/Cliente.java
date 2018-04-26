/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author Alunotgn
 */
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args)
            throws UnknownHostException, IOException {
        String txt;
        txt = "TESTEEEEEEEE";
        Socket cliente = new Socket("127.0.0.1", 12345);
        System.out.println("O cliente se conectou ao servidor!");

        /**
         * **** Jeito do Fontes:
         *
         * String txt = "alo";
         *
         * PrintStream saida = new PrintStream(cliente.getOutputStream());
         * Scanner entrada = new Scanner(cliente.getInputStream());
         * saida.println(txt);
         *
         * while(entrada.hasNextLine()){ txt = entrada.nextLine(); sysout(txt);
         * if(txt.equals("alo")) { saida.println("correto"); }else{
         * saida.println("Errado"); } }
         *****
         */
        Scanner teclado = new Scanner(System.in);
        Scanner entrada = new Scanner(cliente.getInputStream());
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
            System.out.println(entrada.nextLine());
        }
        saida.close();
        teclado.close();

        //saida.println(txt);
        //saida.close();
    }
}
