package threadsdemo.exempleracecondition;

import java.util.ArrayList;
import java.util.List;

public class CorridaMoto {

    //TODO testar com 20 competidores e 30 corridas
    private static final int TOTAL_COMPETIDORES = 10;
    private static final int TOTAL_CORRIDAS = 10;
    private static final int MAX_PONTOS = 10;
    private static final List<Integer> pontuacaoTotal = new ArrayList<>();
    private static final List<Integer> ordemChegadaFinal = new ArrayList<>();
    private static final List<String> nomesCompetidores = new ArrayList<>(TOTAL_COMPETIDORES);

    CorridaMoto() {

        for (int i = 0; i < TOTAL_COMPETIDORES; i++) {
            pontuacaoTotal.add(0);
            nomesCompetidores.add("Competidor #%s".formatted(i + 1));
        }


        for (int i = 0; i < TOTAL_CORRIDAS; i++) {

            List<Thread> threadCorridas = new ArrayList<>(TOTAL_COMPETIDORES);
            Corrida corrida = new Corrida();

            for (int j = 0; j < TOTAL_COMPETIDORES; j++) {
                Competidor competidor = new Competidor(nomesCompetidores.get(j), corrida, j);
                Thread threadCompetidor = new Thread(competidor);
                threadCorridas.add(threadCompetidor);
                threadCompetidor.start();
            }
            for (Thread threadCompetidor : threadCorridas) {
                try {
                    threadCompetidor.join();
                } catch (InterruptedException ex) {
                    System.err.println("Error " + ex.getMessage());
                }
            }
            corrida.atualizarTabelaPontos();
        }
        podio();
    }

    public void podio() {

        List<Integer> indices = new ArrayList<>(TOTAL_COMPETIDORES);
        for (int i = 0; i < TOTAL_COMPETIDORES; i++) {
            indices.add(i);
        }

        indices.sort((i1, i2) -> pontuacaoTotal.get(i2).compareTo(pontuacaoTotal.get(i1)));

        System.out.println("\n==== Pódio ====");
        for (int i = 0; i < 3; i++) {
            int indice = indices.get(i);
            int competidor = ordemChegadaFinal.get(i);
            System.out.println(nomesCompetidores.get(competidor) + " com " + pontuacaoTotal.get(indice) + " pontos");
        }

        System.out.println("\n==== Tabela de Pontos ====");
        for (int i = 0; i < TOTAL_COMPETIDORES; i++) {
            int indice = indices.get(i);
            int competidor = ordemChegadaFinal.get(i);
            System.out.println(nomesCompetidores.get(competidor) + " com " + pontuacaoTotal.get(indice) + " pontos");
        }
    }

    public static class Competidor implements Runnable {
        private final String nome;
        private final int indice;
        private final Corrida corrida;

        public Competidor(String nome, Corrida corrida, int indice) {
            this.nome = nome;
            this.corrida = corrida;
            this.indice = indice;
        }

        @Override
        public void run() {
            corrida.cruzarLinhaChegada(nome, indice);
        }
    }

    public static class Corrida {
        private static final List<Integer> ordemChegada = new ArrayList<>();
        //TODO testar sem o synchronized
        public void cruzarLinhaChegada(String nome, int indice) {
            synchronized (ordemChegada) {
                ordemChegada.add(indice);

            }
        }

        public void atualizarTabelaPontos() {
            synchronized (ordemChegada) {
                for (int i = 0; i < ordemChegada.size(); i++) {
                    int competidor = ordemChegada.get(i);
                    if (i < MAX_PONTOS) {
                        pontuacaoTotal.set(competidor, pontuacaoTotal.get(competidor) + (MAX_PONTOS - i));
                    }
                }
                ordemChegadaFinal.addAll(ordemChegada);
                ordemChegada.clear();
            }
        }
    }

    public static void main(String[] args) {
        new CorridaMoto();
    }
}
