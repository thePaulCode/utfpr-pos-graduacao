/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.javaserverclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

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
            connection = new Socket("localhost", 55000);
                                
            // send int number
            int number = 21;
            outputData = new DataOutputStream(connection.getOutputStream());
            outputData.writeInt(number);
       
            // receive server answer
            String result = "";
            inputData = new DataInputStream(connection.getInputStream());
            result = inputData.readUTF();
            
            System.out.println("\t\tServer answer: " + result);
            // close
            connection.close();
        
        } catch(IOException ex){
            
            Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, "SEVERE ERROR", ex);

        }
    }
    
}
