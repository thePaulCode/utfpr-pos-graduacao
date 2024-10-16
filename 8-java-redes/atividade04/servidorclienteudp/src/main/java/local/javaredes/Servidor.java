/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.javaredes;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author engen
 */
public class Servidor extends Thread{
    
    private DatagramSocket connection;
    private DatagramPacket datagram;
    private static ObjectInputStream objInput;
    private static ByteArrayInputStream inputStream;
    private Pessoa pessoa;
    
    public Servidor(){
        
    }
    
    public Servidor(DatagramSocket connection, DatagramPacket datagram){
        this.connection = connection;
        this.datagram = datagram;
    }
    
    @Override
    public void run(){
        try {
          
            inputStream = new ByteArrayInputStream(datagram.getData());
            objInput = new ObjectInputStream(inputStream);
            Pessoa pessoa1 = (Pessoa) objInput.readObject();

            System.out.println("Objeto recebido:\n\tNome: %s \n\tIdade: %d"
                    .formatted(pessoa1.getNome(), pessoa1.getIdade()));

            byte[] respostaAoCliente = "Dados recebidos corretamente!".getBytes();
            datagram = new DatagramPacket(
                    respostaAoCliente,
                    respostaAoCliente.length,
                    datagram.getAddress(),
                    datagram.getPort()
            );
            
            connection.send(datagram);

        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Aguardando conexao... ");
            DatagramSocket connection = new DatagramSocket(50000);
            while (true) {
                System.out.println("Aguardando requisicao...");
                DatagramPacket datagram = new DatagramPacket(new byte[1024], 1024);
                connection.receive(datagram);
                        
                Servidor tServidor = new Servidor(connection, datagram);
                tServidor.start();
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
