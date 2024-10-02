/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package local.javaredes;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Santos
 */
public class ServidorSemThread {
    
    private static DatagramSocket connection;
    private static DatagramPacket datagram;
    
    private static ByteArrayInputStream inputStream;
    private static ObjectInputStream objInput;
    
    public ServidorSemThread(){}   

    public static void main(String[] args) {
        
        try{
            System.out.println("Aguardando conexao... ");
            connection = new DatagramSocket(50000);
            
            while(true){
                System.out.println("Aguardando requisicao...");
                datagram = new DatagramPacket(new byte[1024], 1024);
                connection.receive(datagram);
                
                inputStream = new ByteArrayInputStream(datagram.getData());
                objInput = new ObjectInputStream(inputStream);
                Pessoa pessoa1 = (Pessoa) objInput.readObject();
                
                System.out.printf("Objeto Pessoa recebido do cliente\n\tNome: %s, \n\tIdade: %d "
                    .formatted(pessoa1.getNome(), 
                               pessoa1.getIdade())).println();
                                      
                
                byte[] answer = "Dados recebidos corretamente".getBytes();
                
                datagram = new DatagramPacket(
                                   answer, 
                                    answer.length, 
                                    datagram.getAddress(), 
                                  datagram.getPort()
                                );
                
                connection.send(datagram);
            }
        
        } catch (IOException ex) {
            Logger.getLogger(ServidorSemThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorSemThread.class.getName()).log(Level.SEVERE, null, ex);
        }        
           
    }

}
