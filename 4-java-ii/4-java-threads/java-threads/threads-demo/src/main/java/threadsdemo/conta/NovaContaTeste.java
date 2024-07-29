package threadsdemo.conta;

public class NovaContaTeste implements Runnable{

    private final static Conta conta = new Conta();


    public static void main(String[] args) {
        NovaContaTeste paul = new NovaContaTeste("paul");
        NovaContaTeste stll = new NovaContaTeste("stll");

    }

    Thread threadName;
    public NovaContaTeste(String name){
        threadName = new Thread(this, name);
        threadName.start();
    }

    private void saque(int valor) throws InterruptedException {
        synchronized (conta) {
            if (conta.getSaldo() >= valor) {
                System.out.println(Thread.currentThread().getName() + " indo realizar saque.");
                conta.saque(valor);
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " saque realizado, saldo " + conta.getSaldo());

            } else {
                System.out.println(Thread.currentThread().getName() + " saque indisponivel, saldo: " + conta.getSaldo());


            }
        }
    }

    @Override
    public void run(){

        for (int i = 0; i < 5; i++) {

            try {
                saque(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
