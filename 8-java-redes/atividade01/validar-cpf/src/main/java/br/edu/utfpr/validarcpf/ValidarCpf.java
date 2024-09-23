/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.utfpr.validarcpf;

/**
 *
 * @author engen
 */
public class ValidarCpf {
    
    public boolean checarCpf(String cpf){
        
        //String cpf = "222.222.222-22";
        
        // retira caracteres especiais
        cpf = cpf.replaceAll("[^\\d]", "");
        int soma = 0;
        
        // verificar se o cpf tem 11 digitos
        if(cpf.length() != 11){
            return false;
        }        
        
        // calcular o primeiro digito verificador
        for(int i=0; i < 9; i++){
            
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
        for (int i=0; i < 10; i++){
            soma += (cpf.charAt(i) - '0') * (11-i);
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

    public static void main(String[] args) {
        
        ValidarCpf validar = new ValidarCpf();
        
        if(validar.checarCpf("070+249*689-82")){
            
            System.out.println("CPF Valido!");
                               
        } else {
        
            System.out.println("CPF Invalido!");
        }        
        

    }
}
