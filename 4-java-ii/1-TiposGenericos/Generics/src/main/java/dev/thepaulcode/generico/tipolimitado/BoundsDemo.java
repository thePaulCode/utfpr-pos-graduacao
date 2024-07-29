package dev.thepaulcode.generico.tipolimitado;

public class BoundsDemo {

    public static void main(String[] args) {

        NumericFns<Integer> iOb = new NumericFns<>(5);

        System.out.println("\n\tReciproco de iOb e: " + iOb.reciprocal());

        System.out.println("\n\tComponente Fracionario de iOb e " + iOb.fraction());
    }
}
