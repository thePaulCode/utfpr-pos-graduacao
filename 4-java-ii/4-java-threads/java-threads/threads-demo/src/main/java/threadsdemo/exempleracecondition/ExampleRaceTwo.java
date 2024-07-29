package threadsdemo.exempleracecondition;

import java.util.ArrayList;
import java.util.List;

public class ExampleRaceTwo {
    private static final int TOTAL_ESCRITORES = 10;

    ExampleRaceTwo(){
        final Livros livros = new Livros();
        for (int i = 0; i < TOTAL_ESCRITORES; i++) {
            final Escritores escritor = new Escritores("Escritor #%s".formatted(i + 1), livros);
            final Thread thread = new Thread(escritor);
            thread.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        livros.ler();
    }

    public static void main(String[] args) {
        new ExampleRaceTwo();
    }
    public static class Escritores implements Runnable{
        private final String nome;
        private final Livros livros;
        Escritores(String nome, Livros livros){
           this.nome = nome;
           this.livros = livros;
        }

        @Override
        public void run() {
            livros.escrever("Alguma ideia do escritor " + nome);
        }
    }
    public static class Livros{

        private final List<String> paginas = new ArrayList<>();

        public void escrever(String texto){
            //synchronized (paginas){
                paginas.add(texto);
          // }
        }

        public void ler (){
            paginas.forEach(System.out::println);
        }
    }
}
