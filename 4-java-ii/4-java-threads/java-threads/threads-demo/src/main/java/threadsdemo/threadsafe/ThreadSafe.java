package threadsdemo.threadsafe;

public class ThreadSafe {
    public static void main(String[] args) {
        NameList name = new NameList();
        name.add("Paull San");
        class RemovedorDeNomes extends Thread {

            public void run() {
                name.removeFirst();
            }
        }


        new RemovedorDeNomes().start();
        new RemovedorDeNomes().start();

    }
}
