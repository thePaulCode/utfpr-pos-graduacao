package dev.thepaulcode.generico.tipogen;

public class Generico<T> {
    // declara um objeto de tipo T
    private T ob;

    // Passa para o construtor
    // uma referencia a um objeto de tipo T
    public Generico(T o) {
        ob = o;
    }

    // Retorna ob
    public T getOb() {
        return ob;
    }

    // Exibe o tipo de T
    public void showType() {
        System.out.println("\n\tTipo de T -> " + ob.getClass().getName());
    }

}
