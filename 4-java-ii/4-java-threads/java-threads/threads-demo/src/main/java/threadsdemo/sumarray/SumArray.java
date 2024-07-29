package threadsdemo.sumarray;

public class SumArray {

    private int sum;

   // public SumArray(){}

    synchronized int sumArray(int nums[]){
        sum = 0;

        for (int num : nums) {
            sum += num;
            System.out.println("Running total for " + Thread.currentThread().getName()+
                    " is " + sum + " " + Thread.currentThread().isAlive());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return sum;
    }
}
