import jeliot.io.*;

public class Aluno {


    public static void main(String args[]) {
        
        InterfaceAluno stella = new InterfaceAluno();

        stella.localI();
        stella.incluirAluno();

    }
}



public class InterfaceAluno {


    public void localI() {
    
        System.out.println("\nLocalI");

    }

    public void incluirAluno() {

        ControllerAluno stella = new ControllerAluno();

        int ra = 21;
        String nome = "Stella";

        System.out.println("\nIncluirAluno " + ra + " - " + nome);

        stella.localC();
        stella.validarAluno(ra, nome);
    }
}



public class ControllerAluno {


    public void localC() {
    
        System.out.println("\nLocalC");

    }

    public void validarAluno(int ra, String nome) {

        ArmazenarAluno stella = new ArmazenarAluno();
        int pRa = ra;

        String pNome = nome;
        

        if (pRa < 10) {
            
            System.out.println("\nValor de RA deve ser maior que 10.");
            pRa = 20;
        } else {

            System.out.println("\nValor de RA Valido.");

            System.out.println("\nSolicitar ArmazenarAluno " + ra + " - " + nome);

            stella.localA();
            stella.armazenar(pRa, pNome);
        }
        

        
    }
}



public class ArmazenarAluno {


    public void localA() {
    
        System.out.println("\nLocalA");

    }

    public void armazenar(int pRa, String pNome) {
    
        int salvarRa = pRa;
        String salvarNome = pNome;    
        System.out.println("\nDados forma salvos. RA: " + salvarRa + " - " + " Nome: " + salvarNome);
        
    }
}

