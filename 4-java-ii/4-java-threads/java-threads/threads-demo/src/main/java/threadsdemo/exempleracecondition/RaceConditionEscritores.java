package threadsdemo.exempleracecondition;

import java.util.ArrayList;
import java.util.List;

public class RaceConditionEscritores {
    private static final int TOTAL_ESCRITORES = 5;
    RaceConditionEscritores(){
        Livros livros = new Livros();
        for (int i = 0; i < TOTAL_ESCRITORES; i++) {
            Escritores escritores = new Escritores("Escritores #%s".formatted(i+1), livros);
            Thread thread = new Thread(escritores);
            thread.start();
        }

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        livros.ler();
    }

    public static void main(String[] args){
        new RaceConditionEscritores();
    }

   public static class Escritores implements Runnable{
       private final Livros livros;
       private final String nome;

       public Escritores(String nome, Livros livros){
           this.livros = livros;
           this.nome = nome;
       }

       @Override
       public void run() {
           livros.escrever("Alguma ideia do " + nome);
       }
   }
    public static class Livros {
        private final List<String> pages = new ArrayList<>();

        public void escrever(String texto){
            synchronized (pages) {
                pages.add(texto);
            }
        }

        public void ler(){
            pages.forEach(System.out::println);
        }
    }

}