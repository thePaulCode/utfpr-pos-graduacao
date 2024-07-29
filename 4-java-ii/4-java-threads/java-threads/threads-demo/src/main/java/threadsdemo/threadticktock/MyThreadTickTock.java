package threadsdemo.threadticktock;

public class MyThreadTickTock implements Runnable  {

    Thread threadName;
    static TickTock tickTock = new TickTock();

    public MyThreadTickTock(String name){
        threadName = new Thread(this, name);
        //tickTock = tt;
        threadName.start();
    }

    @Override
    public void run(){
        if(threadName.getName().compareTo("Tick") == 0){
            for (int i = 0; i < 5; i++) tickTock.tick(true);
            tickTock.tick(false);
        } else {
            for (int i = 0; i < 5; i++) tickTock.tock(true);
            tickTock.tock(false);
        }

    }
}
