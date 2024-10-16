/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.javaredes;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Paulo Santos
 */
public class ThreadCliente implements Runnable {

    private final String nome;
    private final int idade;
    private final JTextArea servidorResposta;
    
    private DatagramSocket connection;
    private DatagramPacket datagram;
    private ByteArrayOutputStream output;
    private ObjectOutputStream objOutput;
    

    public ThreadCliente(String nome, int idade, JTextArea servidorResposta) {
        this.nome = nome;
        this.idade = idade;
        this.servidorResposta = servidorResposta;
    }   
    
    @Override
    public void run() {
        
        try {
            connection = new DatagramSocket();
            Pessoa pessoa1 = new Pessoa();
            pessoa1.setNome(nome);
            pessoa1.setIdade(idade);
            
            output = new ByteArrayOutputStream();
            objOutput = new ObjectOutputStream(output);
            objOutput.writeObject(pessoa1);
            
            byte[] datas = output.toByteArray();
            DatagramPacket packageSent = new DatagramPacket(
                        datas, 
                    datas.length, 
                    InetAddress.getByName("127.0.0.1"), 
                    50000);
                        
            connection.send(packageSent);
            
            datagram = new DatagramPacket(new byte[120], 120);
            connection.receive(datagram);
           
            String serverAnswer = new String(datagram.getData(), 0, datagram.getLength());

            servidorResposta.setText( "Recebeu do servidor: \n" );
            
            servidorResposta.append(serverAnswer + "\n");
           
   
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
    }
    
}
