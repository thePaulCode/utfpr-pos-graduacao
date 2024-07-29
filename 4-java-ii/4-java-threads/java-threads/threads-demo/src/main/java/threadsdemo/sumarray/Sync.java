package threadsdemo.sumarray;

public class Sync {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        MyThreadArray mt1 = new MyThreadArray("Child#1", a);
        MyThreadArray mt2 = new MyThreadArray("Child#2", a);

        try {
            mt1.threadName.join();
            mt2.threadName.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
