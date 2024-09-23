/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.sockethreads;

import static br.edu.utfpr.sockethreads.ServerT.status;
import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author engen
 */
public class ClientT {
    
    private static Socket connection;
    private static DataInputStream inputData;
    private static DataOutputStream outputData;
    private static BufferedReader br;
    
    public ClientT(){
    }

    public static void main(String[] args){
    
        try {
                       
           while(true){                
                connection = new Socket("localhost", 54321);
                outputData = new DataOutputStream(connection.getOutputStream());
                br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Please enter a message: ");
                String message = br.readLine();
                
                if(message.equalsIgnoreCase("sair")){
                    outputData.writeUTF("sair");
                    System.out.println("Client connection was closed. ");
                    outputData.close();
                    connection.close(); 
                    break;
                } else {
                    outputData.writeUTF(message);
                }
                
           }                        
       
        } catch(IOException ex){
        
            Logger.getLogger(ClientT.class.getName())
                    .log(java.util.logging.Level.SEVERE, "SEVERE ERROR", ex);
        }
    }
    
    
}
