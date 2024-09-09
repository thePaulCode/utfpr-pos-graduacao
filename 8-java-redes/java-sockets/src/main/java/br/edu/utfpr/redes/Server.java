/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.redes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author engen
 */
public class Server {
    
    private static ServerSocket server;
    private static Socket connection;    
    private static DataInputStream inputData;
    private static DataOutputStream outputData;
    
    
    public static void main(String[] args){
    
        
        try {
            System.out.println("Wait connection...");
            // specify a port and wait connection
            
            server = new ServerSocket(55000);
            connection = server.accept();
            
            int value;
            // recieve client data
            inputData = new DataInputStream(connection.getInputStream());            
            value = inputData.readInt();
            
            // process data
            String result = "";
            
            if(value > 0)
                result = "Value is greater than zero.";
            else
                result = "Value is lower than zero.";
        
            // return client data            
            outputData = new DataOutputStream(connection.getOutputStream());
            outputData.writeUTF(result);
            
            // close  
            connection.close();
            
            
            
        } catch(IOException ex){
            
            Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, "SEVERE ERROR");
            
        }             
    
    }
    
}
