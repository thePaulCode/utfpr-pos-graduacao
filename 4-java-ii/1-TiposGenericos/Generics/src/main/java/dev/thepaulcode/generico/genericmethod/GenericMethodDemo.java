package dev.thepaulcode.generico.genericmethod;

public class GenericMethodDemo {
    // Determina se o conteudo de dois arrays e igual
    static <T extends Comparable<T>, V extends T> boolean arraysEqual(T[] x, V[] y){
        if(x.length != y.length) return false;

        for (int i = 0; i < x.length; i++) {
            if(!x[i].equals(y[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Integer nums[] = {1, 2, 3, 4, 5};
        Integer nums2[] = {1, 2, 3, 4, 5};
        Integer nums3[] = {1, 2, 7, 4, 5};
        Integer nums4[] = {1, 2, 7, 4, 5, 6};

        // Note: Os argumentos de tipo T e V sao determinados
        // implicitamento quando o metodo e chamado
        if(arraysEqual(nums, nums))
            System.out.println("\n\tnums equals nums");

        if(arraysEqual(nums, nums2))
            System.out.println("\n\tnums equals nums2");

        if(arraysEqual(nums, nums4))
            System.out.println("\n\tnums equals nums4");
        
        /* Note: Essa parte nao sera compilada, porque
        * nums e dValue nao sao do mesmo tipo
        */
        // Cria um array de Double
//        Double dValue[] = {1.1, 2.2, 3.3, 4.4 };
//        if(arraysEqual(nums, dValue))
//            System.out.println("\n\tnums equals nums4");
    }
}
