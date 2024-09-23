/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package local.javaredes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Santos
 */
public class Servidor {
    
    private static ServerSocket server;
    private static  Socket connection;
    private static  ObjectInputStream objInput;
    private static  ObjectOutputStream objOutput;
    private static DataOutputStream outputData;

    public Servidor(){}   

    public static void main(String[] args) {
        
        try{
            System.out.println("Aguardando conexao... ");
            server = new ServerSocket(50000);
            connection = server.accept();
                        
            objInput = new ObjectInputStream(connection.getInputStream());
            Pessoa pessoaRecebida = (Pessoa) objInput.readObject();
            outputData = new DataOutputStream(connection.getOutputStream());
            
            if(pessoaRecebida != null){
                System.out.printf("Objeto recebido: %s,\nNome: %s, Idade: %s"
                    .formatted(pessoaRecebida.getClass().getName(), 
                            pessoaRecebida.getNome(), 
                            pessoaRecebida.getIdade() )).println();
                outputData.writeUTF("Recebeu do servidor:\nDados recebidos corretamente!");
            } else {
                outputData.writeUTF("Recebeu do servidor:\nDados nao foram recebidos corretamente.");
            }
            objInput.close();
            connection.close();
        
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }        
           
    }

}
