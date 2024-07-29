package dev.thepaulcode.generico.argcuringa;

public class WildCardDemo {

    public static void main(String[] args) {

        NumericFns<Integer> iOb = new NumericFns<>(6);

        NumericFns<Double> dOb = new NumericFns<>(-6.0);

        NumericFns<Long> lOb = new NumericFns<>(6L);

        System.out.println("\n\tTestando iOb e dOb:");
        if(iOb.absEqual(lOb))
            System.out.println("\t\tValores absolutos sao iguais.");
        else
            System.out.println("\t\tValores absolutos sao diferentes");

    }
}
