package devthepaulcode.numerictestinterface;

public class LambdaDemo2 {

    // Usar a mesma interface funcional para testar diferentes
    // abordagens
    public static void main(String[] args) {
        // Essa expressao lambda determina se um numero
        // e expressao do outro
        NumericTest<Integer> isFactor = (n, d) -> (n % d) == 0;

        if(isFactor.test(10, 2))
            System.out.println("\n\t2 e um fator de 10");
        if(!isFactor.test(10, 3))
            System.out.println("\t3 nao e um fator de 10");

        // Essa expressao lambda retorna true se um numero
        // for menor que o outro
        NumericTest<Double> lessThan = (n, m) -> (n < m);

        if(lessThan.test(21.1, 31.9))
            System.out.println("\n\t21.1 e menor que 31.9");

        if(!lessThan.test(7.2, 2.7))
            System.out.println("\t7.2 nao e menor que 2.7");

        // Essa expressao lambda retorna true se os
        // valores absolutos dos args forem iguais

        NumericTest<Integer> absEqual = (n, m) -> ( n < 0 ? -n : n) == (m < 0 ? -m : m);

        if(absEqual.test(4, -4))
            System.out.println("\n\tOs valores absolutos de 4 e -4 sao iguais");
        if(!absEqual.test(4, -2))
            System.out.println("\tOs valores absolutos de 4 e -2 nao sao iguais");

    }
}
