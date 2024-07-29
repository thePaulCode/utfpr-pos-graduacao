package threadsdemo.atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

public class Contador {

    private AtomicInteger atomicInteger = new AtomicInteger();
    private int counter;

    public void incrementar(){
       atomicInteger.getAndIncrement();
       counter++;
    }

    public int getContadorAt(){
        return atomicInteger.intValue();
    }

    public int getCounter(){
        return counter;
    }
}
