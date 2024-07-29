package threadsdemo.sumarray;

public class MyThreadArray implements Runnable{

    Thread threadName;
    static SumArray sa = new SumArray();
    int[] a;
    int answer;

    public MyThreadArray(String name, int[] nums){
        threadName = new Thread(this, name);
        a = nums;
        threadName.start();
    }

    @Override
    public void run() {
        int sum;

        System.out.println(Thread.currentThread().getName() +
                " starting." + " " + Thread.currentThread().getState());

        answer = sa.sumArray(a);

        System.out.println("Sum for " + Thread.currentThread().getName() +
                " is " + answer + " " + Thread.currentThread().isAlive());

        System.out.println(Thread.currentThread().getName() +
                " terminating." + " " + Thread.currentThread().isAlive());

    }
}
