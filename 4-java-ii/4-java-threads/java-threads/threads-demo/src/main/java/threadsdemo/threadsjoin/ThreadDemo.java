package threadsdemo.threadsjoin;

// Daemon x User -> priority
//
public class ThreadDemo extends Thread{

    private char c;

    public ThreadDemo(char c){
        this.c = c;

    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            System.out.print(c);

            if(i % 100 == 0 ) System.out.println();
        }
    }

    public static void main(String[] args){

        ThreadDemo t1= new ThreadDemo('A');
        ThreadDemo t2= new ThreadDemo('B');
        ThreadDemo t3= new ThreadDemo('C');
        ThreadDemo t4= new ThreadDemo('D');

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
