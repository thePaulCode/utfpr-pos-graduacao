package threadsdemo.racecondition;

import java.util.stream.IntStream;

public class Sincronismo {

    public static void main(String[] args) {
        final var contador = new Contador();
        final var t1 = new Thread(new Tarefa(contador));

        t1.start();

        final var t2 = new Thread(new Tarefa(contador));

        t2.start();


        final var t3 = new Thread(new Tarefa(contador));

        t3.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(contador.getValor());
    }

    public static class Tarefa implements Runnable{

        private final Contador contador;
        public Tarefa(Contador contador){
            this.contador = contador;
        }
        @Override
        public void run(){
            IntStream.rangeClosed(1, 1000)
                    .forEach(valor -> this.contador.incrementar());
            System.out.println(Thread.currentThread().getName() + " valor: " + contador.getValor());

        }
    }
    private static final class Contador{
        private int valor;

        public Contador(){
            this.valor = 0;
        }

        public synchronized void incrementar(){
            this.valor++;
        }

        public int getValor(){
            return valor;
        }
    }

}
