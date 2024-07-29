package dev.thepaulcode.generico.tipogen;

public class GenericPrinter<T> {

    T thingToPrint;

    public GenericPrinter (T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint + "!!!");
    }

    public static void main(String[] args) {
        GenericPrinter<Integer> iPrint = new GenericPrinter<>(21);

        GenericPrinter<String> sPrint = new GenericPrinter<>("\nStella");

        iPrint.print();
        sPrint.print();
    }
}
