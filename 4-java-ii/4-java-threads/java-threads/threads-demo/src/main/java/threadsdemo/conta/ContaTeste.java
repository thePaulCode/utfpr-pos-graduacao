package threadsdemo.conta;

public class ContaTeste implements Runnable{
    Conta conta = new Conta();

    private synchronized void saque(int valor) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " vai realizar o saque");

        if(conta.getSaldo() >= valor){
            conta.saque(valor);
            System.out.println(Thread.currentThread().getName() + " realizou o saque, saldo atual: " + conta.getSaldo());

            Thread.sleep(1000);
        } else {
            System.out.println(Thread.currentThread().getName() + " saque indisponivel, saldo: " + conta.getSaldo());
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                saque(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ContaTeste contaTeste = new ContaTeste();
        Thread paulo = new Thread(contaTeste, "Paul");
        Thread stll = new Thread(contaTeste, "Stll");

        paulo.start();
        stll.start();


    }
}
