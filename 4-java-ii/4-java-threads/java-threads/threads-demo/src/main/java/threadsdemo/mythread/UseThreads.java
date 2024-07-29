package threadsdemo.mythread;

public class UseThreads {
    public static void main(String[] args)  {



        // Instanciação de um objeto thread dentro do construtor
        // da classe que implementa o runnable

        //Thread mt = new Thread(myThread, "Child #1");

        //myThread.start();

        // Agora, a Thread começa quando é criada.
        MyThread myThread1 = new MyThread("Child #1");
        MyThread myThread2 = new MyThread("Child #2");
        MyThread myThread3 = new MyThread("Child #3");

        do {
            System.out.println(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while (myThread1.thrdName.isAlive() ||
                myThread2.thrdName.isAlive() ||
                myThread3.thrdName.isAlive());

        System.out.println("Main thread ending.");
    }

}
