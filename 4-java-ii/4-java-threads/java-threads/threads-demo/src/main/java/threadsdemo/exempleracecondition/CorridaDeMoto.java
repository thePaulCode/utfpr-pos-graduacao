package threadsdemo.exempleracecondition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CorridaDeMoto {
    private static final int TOTAL_COMPETIDORES = 10;
    private static final int TOTAL_CORRIDAS = 10;
    private static final int PONTOS_MAXIMOS = 10;
    private static final int PONTOS_MINIMOS = 1;
    private static final int[] totalPontos = new int[TOTAL_COMPETIDORES];

    CorridaDeMoto(){

        for (int j = 0; j < TOTAL_CORRIDAS; j++) {

            List<Thread> threadCorrida = new ArrayList<>(TOTAL_CORRIDAS);
            final Corrida corrida = new Corrida();
            System.out.println("Iniciando a corrida " + (j+1));
            for (int i = 0; i < TOTAL_COMPETIDORES; i++) {

                final Competidor competidor = new Competidor("Competidor #%s".formatted(i + 1), corrida, i);
                final Thread threadCompetidor = new Thread(competidor);
                threadCorrida.add(threadCompetidor);
                threadCompetidor.start();
            }

            for (Thread threadCompetidor : threadCorrida){
                try {
                    threadCompetidor.join();

                } catch (InterruptedException ex) {
                    System.err.println("error: " + ex.getMessage());
                }
            }
            corrida.atualizarTabelaPontos();
        }
        podio();
    }

    public static void main(String[] args) {
        new CorridaDeMoto();
    }

    private void podio(){
        System.out.println("==== Podio ====");
        int vencedor = 0;
        int maxPontos = 0;
        for (int i = 0; i < TOTAL_COMPETIDORES; i++) {
            System.out.println("Competidor " +(i+1) + ": " + totalPontos[i] + " pontos");
            if (totalPontos[i] > maxPontos){
                maxPontos = totalPontos[i];
                vencedor = i;
            }
        }
        System.out.println("Vencedor " + (vencedor+1) + " Pontos: " + maxPontos);
    }

    public static class Competidor implements Runnable{
        private String nome;
        private final Corrida corrida;
        private final int indice;

        public Competidor(String nome, Corrida corrida, int indice){
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

        private final List<Integer> ordemChegada = new ArrayList<>();
        private final List<Integer> podio = new ArrayList<>(3);
        private final AtomicInteger posicao = new AtomicInteger(0);

        public void cruzarLinhaChegada(String nome, int indice){
            synchronized (posicao) {
                int chegada = posicao.incrementAndGet();
                ordemChegada.add(indice);
                podio.add(indice);
                System.out.println(nome + " cruzou a linha de chegada em " + chegada + podio.toString() +  "º lugar.");
            }
        }

        public void atualizarTabelaPontos(){
            //System.out.println("==== Tabela de pontos ====");
            for (int i = 0; i < ordemChegada.size(); i++) {
                int competidor = ordemChegada.get(i);
                totalPontos[competidor] += (PONTOS_MAXIMOS - i);
            }
        }

    }
}
