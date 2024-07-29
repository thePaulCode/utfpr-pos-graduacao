package threadsdemo.conta;

public class Conta {

    private int saldo = 60;

    public Conta(){

    }
    public int getSaldo(){
        return saldo;
    }

    public void saque(int valor){
        saldo = saldo - valor;
    }

}
