package threadsdemo.mythread;

public class MyThread implements Runnable{

    Thread thrdName;

    public MyThread(String name){
        thrdName = new Thread(this, name);
        thrdName.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread starting.");

            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(400);
                    System.out.println("In " + Thread.currentThread().getName()  + " count is " + i);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()  + " terminating");

    }
}
