/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.javaredes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Santos
 */
public class Cliente {
    
    private static Socket connection;
    private static DataInputStream inputData;
    private static DataOutputStream outputData;
    private static BufferedReader br;

    public Cliente(){}    
    
    public static void main(String[] args){
   
        try{
            
            connection = new Socket("127.0.0.1", 50000);
            
            outputData = new DataOutputStream(connection.getOutputStream());
            // Usuario digita o CPF    
            String cpf = ""; 
             
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite um CPF para verificacao: ");            
            cpf = br.readLine();

            outputData.writeUTF(cpf);
            
            // resposta da verificacao da validade do CPF
            inputData = new DataInputStream(connection.getInputStream());
            System.out.println(inputData.readUTF());
            
            inputData.close();
            outputData.close();
            connection.close();            
        
        }catch(IOException ex){
        
            Logger.getLogger(Cliente.class.getName())
                    .log(java.util.logging.Level.SEVERE, "SEVERE ERROR", ex);
        }
    }
}
