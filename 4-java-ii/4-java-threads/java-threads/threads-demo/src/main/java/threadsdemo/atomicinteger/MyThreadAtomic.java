package threadsdemo.atomicinteger;

public class MyThreadAtomic implements Runnable{

    static Contador contador = new Contador();

    Thread threadName;

    public MyThreadAtomic(String name){
        threadName = new Thread(this, name);

    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            contador.incrementar();

        }


    }
}
