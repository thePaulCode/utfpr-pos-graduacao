package threadsdemo.threadlistamembros;

import java.util.LinkedList;
import java.util.Queue;

public class ListaMembros {

    private Queue<String> emails = new LinkedList<>();
    private boolean aberta = true;

    public void adicionarEmailMembro(String email){
        synchronized (this.emails){
            this.emails.add(email);
            System.out.println(email + "Email adicionado na lista");
            System.out.println("Notificando as Threads que estao em espera.");
            this.emails.notifyAll();
        }
    }

    public String obterEmailMembro(){
        String email = null;

        try {
            synchronized (this.emails){
                while (this.emails.size()==0){
                    if(!aberta) return null;
                    System.out.println("Lista vazia, colocando a " + Thread.currentThread().getName() + " em modo espera.");
                    this.emails.wait();
                }
                email = emails.poll();

            }
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return email;
    }

    public int getEmailPendente(){
        synchronized (emails){
            return this.emails.size();
        }
    }

    public boolean isAberta(){
        return aberta;
    }

    public void fecharLista(){
        System.out.println("Notificando todas as Threads e fechar a lista.");
        aberta = false;
        synchronized (emails){
            this.emails.notifyAll();
        }
    }
}
