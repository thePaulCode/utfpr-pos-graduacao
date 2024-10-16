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
public class ServidorTeste01 {
    
    private static DatagramSocket connection;
    private static DatagramPacket datagram;
    private static ObjectInputStream objInput;
    private static ByteArrayInputStream inputStream;
    private Pessoa pessoa;
    
    public ServidorTeste01(){
        
    }
    
    public static void tempo() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServidorSemThread.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        try {
            connection = new DatagramSocket(50000);
            while (true) {

                datagram = new DatagramPacket(new byte[1024], 1024);
                connection.receive(datagram);

                inputStream = new ByteArrayInputStream(datagram.getData());
                objInput = new ObjectInputStream(inputStream);
                Pessoa pessoa1 = (Pessoa) objInput.readObject();
                
                System.err.println("Objeto recebido:\n\tNome: %s \n\tIdade: %d"
                        .formatted(pessoa1.getNome(), pessoa1.getIdade()));

                // enviar resposta ao cliente
                byte[] respostaAoCliente = "Objeto recebido".getBytes();
                datagram = new DatagramPacket(
                        respostaAoCliente,
                           respostaAoCliente.length,
                        datagram.getAddress(),
                        datagram.getPort()          
                );
                tempo();
                connection.send(datagram);
                
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ServidorTeste01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorTeste01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
