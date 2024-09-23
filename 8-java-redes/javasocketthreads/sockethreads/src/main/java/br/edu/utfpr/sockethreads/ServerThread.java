///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package br.edu.utfpr.sockethreads;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.logging.Logger;
//
///**
// *
// * @author engen
// */
//public class ServerThread extends Thread {
//    
//    private static Socket connection;
//    private static ServerSocket server;
//    private static DataInputStream inputData;
//    private static DataOutputStream outputData;
//    private Thread threadName;
//    
//    public ServerThread(Socket connection){
//        
//        this.connection = connection;            
//    }
//    
//     @Override
//    public void run() {
//
//        try {
//            
//            inputData = new DataInputStream(connection.getInputStream());            
//            String message = inputData.readUTF();
//            
//            outputData = new DataOutputStream(connection.getOutputStream());            
//            outputData.writeUTF(message.toUpperCase());
//            
//            inputData.close();
//            outputData.close(); 
//            connection.close();
//           
//        }catch(IOException ex){
//            
//            Logger.getLogger(ServerThread.class.getName())
//                    .log(java.util.logging.Level.SEVERE, "SEVERE ERROR", ex);
//        }
//    }    
//        
//    public static void main(String[] args){
//            
//        try{     
//            ServerSocket server = new ServerSocket(54321);
//
//            while(true){
//                Socket connection = server.accept(); 
//                System.out.println("Um cliente se conectou!");
//                ServerThread threadServer = new ServerThread(connection);
//                threadServer.start();
//            }
//                       
//        }catch(IOException ex){
//            
//            Logger.getLogger(ServerThread.class.getName())
//                    .log(java.util.logging.Level.SEVERE, "SEVERE ERROR", ex);
//        }
//        
//    
//    }
//
//   
//    
//}
