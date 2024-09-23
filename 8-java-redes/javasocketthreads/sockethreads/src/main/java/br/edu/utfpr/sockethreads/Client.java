///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package br.edu.utfpr.sockethreads;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//import java.util.logging.Logger;
//
///**
// *
// * @author engen
// */
//public class Client {
//    
//    private static Socket connection;
//    private static DataInputStream inputData;
//    private static DataOutputStream outputData;
//    
//    public static void main(String[] args){
//        
//        try {
//            
//            connection = new Socket("localhost", 54321);
//            
//            String message = "Hello NetWork World 2024!";
//            
//            outputData = new DataOutputStream(connection.getOutputStream());
//            outputData.writeUTF(message);
//            
//            inputData = new DataInputStream(connection.getInputStream());            
//            System.out.println(inputData.readUTF());
//            
//            outputData.close();
//            inputData.close();   
//            connection.close();
//            
//        } catch(IOException ex){
//            
//            
//        }   
//    
//    
//    }
//    
//}
