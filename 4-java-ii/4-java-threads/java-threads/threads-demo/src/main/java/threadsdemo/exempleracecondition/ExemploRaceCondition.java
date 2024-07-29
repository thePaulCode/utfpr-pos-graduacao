package threadsdemo.exempleracecondition;

import java.util.ArrayList;
import java.util.List;

public class ExemploRaceCondition {

    private static final int TOTAL_ESCRITORES = 10;

    ExemploRaceCondition() {

        // cria o objeto compartilhado
        final var livro = new Livro();

        // instanciamos as threads concorrentes
        for (int i = 0; i < TOTAL_ESCRITORES; i++) {
            final var escritor = new Escritor("Escritor #%s".formatted(i + 1), livro);
            final var thread = new Thread(escritor);
            thread.start();
        }

        // logica simples para esperar que o livro tenha o total de escritores requerido
        boolean esperar;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.err.println("erro " + ex.getMessage());
        }

        // le as paginas do livro
        livro.ler();
    }

    public static void main(String[] args) {
        new ExemploRaceCondition();
    }

    private class Escritor implements Runnable {

        private final String nome;
        private final Livro livro;

        public Escritor(String nome, Livro livro) {
            this.nome = nome;
            this.livro = livro;
        }

        @Override
        public void run() {
            livro.escrever("Alguma ideia do escritor " + nome);
        }
    }

    private static class Livro {

        final List<String> paginas = new ArrayList<>();

        public void escrever(String texto) {
            synchronized (paginas) {
                paginas.add(texto);
            }
        }

        public void ler() {
            paginas.forEach(System.out::println);
        }
    }
}