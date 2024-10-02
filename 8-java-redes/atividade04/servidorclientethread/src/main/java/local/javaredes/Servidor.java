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
public class Servidor extends Thread {

    private static ServerSocket server;
    private Socket connection;
    private ObjectInputStream objInput;
    private static ObjectOutputStream objOutput;
    private static DataOutputStream outputData;

    public Servidor(Socket connection, ObjectInputStream objInput) {
        this.connection = connection;
        this.objInput = objInput;
    }

    @Override
    public void run() {

        try {

            Pessoa pessoaRecebida = (Pessoa) this.objInput.readObject();
            outputData = new DataOutputStream(this.connection.getOutputStream());

            if (pessoaRecebida != null) {
                System.out.printf("Objeto recebido:\t\nNome: %s \t\nIdade: %d"
                        .formatted(pessoaRecebida.getNome(),
                                pessoaRecebida.getIdade())).println();
                outputData.writeUTF("Recebeu do servidor:\nDados recebidos corretamente!\n");
            } else {
                outputData.writeUTF("Recebeu do servidor:\nDados não foram recebidos corretamente.");
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

        try {
            System.out.println("Aguardando conexão... ");
            server = new ServerSocket(50000);
            while (true) {                
                
                System.out.println("Aguardando requisições... ");                
                Socket connection = server.accept();
                
                ObjectInputStream objInput = new ObjectInputStream(connection.getInputStream());
                Servidor tServidor = new Servidor(connection, objInput);
                tServidor.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
