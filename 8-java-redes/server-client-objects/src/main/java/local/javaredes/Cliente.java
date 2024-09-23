/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.javaredes;

import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author engen
 */
public class Cliente {
    
    private static Socket connection;
    private static ObjectInputStream objInput;
    private static ObjectOutputStream objOutput;
    private static DataInputStream inputData;
    private Pessoa person;
    
    public Cliente(){
    
    }
    
    public static void main(String[] args) {
    
        try{
            connection = new Socket("localhost", 54321);
            System.out.println("Client connected. ");
            
            objOutput = new ObjectOutputStream(connection.getOutputStream());
            inputData = new DataInputStream(connection.getInputStream());
            
            Pessoa person = new Pessoa();
            if(person.getNome() != null){
                objOutput.writeObject(person);
                System.out.println("Object was sent!");
                System.out.println("Server Answer: " + inputData.readUTF());
            } else {
                System.out.println("Object was not sent.\n Cause: is null.");
            }            
            
            objOutput.close();
            connection.close();            

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }


}
