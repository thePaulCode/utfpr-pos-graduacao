package dev.thepaulcode.generico.interfacegen;


public class GenIfDemo {
    public static void main(String[] args) {

       Integer x[] = {1,2,3,4,5,6};

       MyClass<Integer> ob = new MyClass<>(x);

       int numberToCheck = 1;
       int numberToCheckTwo = 7;

       if(ob.contains(numberToCheck))
           System.out.println("\t%d esta em ob.".formatted(numberToCheck));
       else
           System.out.println("\t%d nao esta em ob.".formatted(numberToCheck));

       if(ob.contains(numberToCheckTwo))
           System.out.println("\t%d esta em ob.".formatted(numberToCheckTwo));
       else
           System.out.println("\t%d nao esta em ob.".formatted(numberToCheckTwo));

    }
}
