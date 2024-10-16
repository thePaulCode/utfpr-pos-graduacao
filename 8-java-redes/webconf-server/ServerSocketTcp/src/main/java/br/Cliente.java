/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author engen
 */
public class Cliente {
    
    private static Socket conexao;
    private static DataOutputStream saida;
    private static DataInputStream entrada;
    
    public static void main(String[] args) {
        
        try {
            // conectar com o servidor
            conexao = new Socket("localhost", 50000);
            
            String mensagemCliente = JOptionPane.showInputDialog("Digite uma palavra: ");

            // enviar dados ao servidor
            saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF(mensagemCliente);
            
            // receber respota do servidor
            entrada = new DataInputStream(conexao.getInputStream());
            entrada.readUTF();
            
            System.out.println("Resposta do servidor: " + entrada.readUTF());
            
            // fechar conexao
            conexao.close();
        } catch (Exception e) {
        }
        
    }
    
}
