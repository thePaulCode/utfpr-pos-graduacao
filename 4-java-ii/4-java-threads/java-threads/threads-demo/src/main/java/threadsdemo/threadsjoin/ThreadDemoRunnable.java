package threadsdemo.threadsjoin;

public class ThreadDemoRunnable implements Runnable {

        private char c;

        public ThreadDemoRunnable(char c){
            this.c = c;

        }
        @Override
        public void run() {
            System.out.println("Thread executando -> " + Thread.currentThread().getName());
            for (int i = 0; i < 1000; i++) {
                System.out.print(c);

                if(i % 100 == 0 ) System.out.println();

                // Fazer Thread voltar para o stato runnable
                //
                if(Thread.currentThread().getName().equals("T4")) {
                    Thread.yield();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadDemoRunnable('A'), "T1");
        Thread t2 = new Thread(new ThreadDemoRunnable('B'), "T2");
        Thread t3 = new Thread(new ThreadDemoRunnable('C'), "T3");
        Thread t4 = new Thread(new ThreadDemoRunnable('D'), "T4");
        // Definir prioridade
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        t2.start();
        t3.start();
        t4.start();
        //t1.start();
    }
}

