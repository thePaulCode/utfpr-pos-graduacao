/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package local.javaredes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Santos
 */
public class Servidor {
    
    private static ServerSocket server;
    private static Socket connection;
    private static DataInputStream inputData;
    private static DataOutputStream outputData;

    public Servidor(){}

    public static void main(String[] args) {
        
        new Servidor();
        
        System.out.println("Aceitando conexoes...");
                
        try{            
            server = new ServerSocket(50000);
            connection = server.accept();
            System.out.println("Cliente se conectou!");
            
            inputData = new DataInputStream(connection.getInputStream());
            String cpf = inputData.readUTF();
            
            String repostaValidacao = "";
            if(checarCpf(cpf)){
                repostaValidacao = "Este CPF e valido.";
            } else{
                repostaValidacao = "Este CPF e invalido.";
            }
            
            outputData = new DataOutputStream(connection.getOutputStream());
            outputData.writeUTF(repostaValidacao);           
            
            inputData.close();
            outputData.close();
            connection.close();
            System.out.println("Fim da conexao.");
	
            
        }catch(IOException ex){
        
            Logger.getLogger(Servidor.class.getName())
                    .log(java.util.logging.Level.SEVERE, "SEVERE ERROR", ex);
        }
    }
    
    public static boolean checarCpf(String cpf){
     
        int soma = 0;
        
        // retira caracteres especiais
        cpf = cpf.replaceAll("[^\\d]", "");
        
        // verificar se o cpf tem 11 digitos
        if(cpf.length() != 11){
            return false;
        }  
        
        // verificar se o cpf tem 11 digitos == 0
        if("00000000000".equals(cpf)){
            return false;
        }
        
        // calcular o primeiro digito verificador
        for(int i=0; i< 9; i++){
            soma += (cpf.charAt(i) - '0') * (10-i);
        }
        
        int primeiroDigitoVerificador = 11 - (soma % 11);
        if(primeiroDigitoVerificador >= 10){
            primeiroDigitoVerificador = 0;
        }    
        
        // verificar se o primeiro digito verificador esta correto
        if(primeiroDigitoVerificador != (cpf.charAt(9) - '0')){
            
            return false;
        }
        
        // calcular segundo digito verificador
        soma = 0;
        for(int i=0; i < 10; i++){
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        if(segundoDigitoVerificador >= 10){
            segundoDigitoVerificador = 0;
        }
        
        // // verificar se o segundo digito verificador esta correto
        if(segundoDigitoVerificador != (cpf.charAt(10)) - '0'){
            
            return false;
        }
        
        return true;
    }
}
