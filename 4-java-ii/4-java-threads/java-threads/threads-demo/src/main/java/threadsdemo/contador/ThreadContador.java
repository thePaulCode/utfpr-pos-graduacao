package threadsdemo.contador;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadContador {

    Thread threadNome;

    public ThreadContador(){


    }

    public static void main(String[] args) throws InterruptedException {
        final Contador contador = new Contador();
        Tarefa tarefa = new Tarefa(contador);
        Thread thread1 = new Thread(tarefa);
        thread1.start();

        Thread thread2 = new Thread(tarefa);
        thread2.start();

        Thread thread3 = new Thread(tarefa);
        thread3.start();
        Thread.sleep(1000);
        System.out.println(contador.getValor());
    }
    public static class Tarefa implements Runnable{
        Contador contador;
        String nome;

        public Tarefa(Contador contador){

            this.contador = contador;
        }

        @Override
        public void run() {
            IntStream.rangeClosed(1, 1000)
                    .forEach(valor -> this.contador.incrementar());


        }
    }
    public static class Contador{
        AtomicInteger valor;

        public Contador(){
            this.valor = new AtomicInteger(0);

        }

        public void incrementar(){

            this.valor.incrementAndGet();
        }
          public int getValor(){
            return valor.get();
        }

    }
}
