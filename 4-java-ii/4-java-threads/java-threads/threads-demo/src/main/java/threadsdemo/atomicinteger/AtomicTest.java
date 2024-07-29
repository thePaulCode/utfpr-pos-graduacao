package threadsdemo.atomicinteger;

import static threadsdemo.atomicinteger.MyThreadAtomic.contador;

public class AtomicTest {
    public static void main(String[] args) {

       // MyThreadAtomic myThreadAtomic = new MyThreadAtomic("ContadorAtomic", contador);
        MyThreadAtomic myCounter = new MyThreadAtomic("Contador1");
        MyThreadAtomic myCounter2 = new MyThreadAtomic("Contador2");

        myCounter.threadName.start();
        myCounter2.threadName.start();
        try {
            myCounter.threadName.join();
            myCounter2.threadName.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(contador.getCounter());
        System.out.println(contador.getContadorAt());




    }
}
