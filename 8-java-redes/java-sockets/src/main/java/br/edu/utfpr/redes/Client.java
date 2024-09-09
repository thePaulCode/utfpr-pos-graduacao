/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.redes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author engen
 */
public class Client {
    
    private static Socket connection;
    private static DataInputStream inputData;
    private static DataOutputStream outputData;
    
    public static void main(String[] args){
        
        try {
            // connect to server
            connection = new Socket("127.0.0.1", 55000);
        
            // send int number
            outputData = new DataOutputStream(connection.getOutputStream());
            int number = 21;
            outputData.writeInt(number);
        
            // receive server answer
            inputData = new DataInputStream(connection.getInputStream());
            String result = inputData.readUTF();
            System.out.println("Server answer: " + result);
            // close
            connection.close();
        
        } catch(IOException ex){
        }
    }
    
}
