package dev.thepaulcode.generico.interfacegen;

public class MyClass <T extends Number> implements Containment<T> {

    T[] ob;

    MyClass(T[] o){
        ob = o;
    }
    @Override
    public boolean contains(T o) {
        T[] x = ob;
        for(int i=0; i < x.length; i++){
           if(x[i].equals(o))
               return true;

        }
       return false;
    }
}
