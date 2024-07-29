package threadsdemo.threadlistamembros;

import javax.swing.*;

public class EntregadorTest {
    public static void main(String[] args) {
        ListaMembros listaMembros = new ListaMembros();
        Entregador entregador1 = new Entregador("Entregador1", listaMembros);
        Entregador entregador2 = new Entregador("Entregador2", listaMembros);

        while(true){
            String email = JOptionPane.showInputDialog("Digite o email do membro:");
            if(email == null || email.isEmpty()){
                entregador1.listaMembros.fecharLista();
                break;
            }
            entregador1.listaMembros.adicionarEmailMembro(email);

        }
    }
}
