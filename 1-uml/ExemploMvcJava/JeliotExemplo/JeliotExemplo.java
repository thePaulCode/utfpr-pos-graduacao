import jeliot.io.*;

public class Aluno {


    public static void main(String args[]) {
        
        InterfaceAluno Pele = new InterfaceAluno();

        Pele.LocalI();
        Pele.Inserir();

    }
}

public class InterfaceAluno {

    public String nome;

    public int Ra;

    public void LocalI() {

        System.out.println("\n\tInterfaceAluno");
    }

    public void Inserir() {

        ValidaAluno Pele = new ValidaAluno();
        System.out.println("\n\tInsercao de Dados");
        nome = "Pele";
        Ra = 30;

        System.out.println("\n"+nome);
        System.out.println("\n"+Ra);

        Pele.LocalV();
        Pele.validar(Ra, nome);

        

    }
    
}

public class ValidaAluno {

    ArmazenarAluno Pele = new ArmazenarAluno();

    public void LocalV() {

        System.out.println("\n\tValidaAluno");
    }

    public void validar(int pRa, String nome) {
        
        if(pRa >=30) {
            
            System.out.println("\n\tRa Valido");

        } else {

            System.out.println("\n\tRa Invalido");

        }
        
        Pele.armazenar(pRa, nome);

    }

    
    
}

public class ArmazenarAluno {

    public int salvarRa;
    public String salvarNome;

    public void LocalA() {

        System.out.println("\n\tArmazenarAluno");
    }

    public void armazenar(int pRa, String nome) {
        
        salvarRa = pRa;
        salvarNome = nome;

    }
    
}
