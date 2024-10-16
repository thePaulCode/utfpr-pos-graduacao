/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author engen
 */
public class ServerSocketTcp {
    
    private static ServerSocket servidor;
    private static Socket conexao;
    private static DataOutputStream saida;
    private static DataInputStream entrada;

    public static void main(String[] args) {
        try {
            // estabelece uma porta
            servidor = new ServerSocket(50000);
            System.out.println("Aceitando conexão...");
            
            // aceitar conexoes -- bloqueante
            conexao = servidor.accept();
            
            // receber conexoes e realizar o servico
            entrada = new DataInputStream(conexao.getInputStream());
            String dadosCliente = entrada.readUTF();
            //String envioCliente = 
            System.out.println("Dados recebidos do cliente: " + dadosCliente.toString());
            saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF("Dados recebidos" + dadosCliente);
            // 
            
            conexao.close();
            
        } catch (Exception e) {
        }
    }
}
