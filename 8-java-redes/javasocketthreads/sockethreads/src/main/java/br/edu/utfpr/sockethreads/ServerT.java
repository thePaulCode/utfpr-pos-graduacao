/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.sockethreads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Logger;

/**
 *
 * @author engen
 */
public class ServerT extends Thread{
    
    private static Socket connection;
    private static ServerSocket server;
    private static DataInputStream inputData;
    private static DataOutputStream outputData;
    static boolean status = true;
    
    public ServerT(Socket connection){
        
        this.connection = connection;
    }
    
    public boolean getStatus(){
        return status;
    }
    @Override
    public void run(){
        
        try{
            inputData = new DataInputStream(connection.getInputStream());
            String messageToTransfom = inputData.readUTF();
            
            if(messageToTransfom.equalsIgnoreCase("sair")){
                
                connection.close();
            
            } else {
                // business rule
                messageToTransfom = messageToTransfom.toUpperCase();
            
                System.out.println("Server answer is: ");
                System.out.println(messageToTransfom);                    
            }
        
        }catch(IOException ex){
        
            Logger.getLogger(ServerT.class.getName())
                    .log(java.util.logging.Level.SEVERE, "SEVERE ERROR", ex);
        }
    
    }
    
    public static void main(String[] args){
       System.out.println("Server Available for connection...");
       try{
           ServerSocket server = new ServerSocket(54321);
           while(true){
               
               connection = server.accept();   
               
               ServerT serverT = new ServerT(connection);
               serverT.start();            
           
           }
       } catch(IOException ex){
        
            Logger.getLogger(ServerT.class.getName())
                    .log(java.util.logging.Level.SEVERE, "SEVERE ERROR", ex);
        }
    
    }
    
}
