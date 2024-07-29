package threadsdemo.mythread;

public class JoinThreads {

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("Child#1");
        MyThread myThread2 = new MyThread("Child#2");
        MyThread myThread3 = new MyThread("Child#3");

        try {
            myThread1.thrdName.join();
            System.out.println("Child #1 is joined.");
            myThread2.thrdName.join();
            System.out.println("Child #2 is joined.");
            myThread3.thrdName.join();
            System.out.println("Child #3 is joined.");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Ending Main Thread.");
    }


}
