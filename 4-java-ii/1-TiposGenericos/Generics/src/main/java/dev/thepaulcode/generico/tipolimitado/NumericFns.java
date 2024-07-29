package dev.thepaulcode.generico.tipolimitado;

public class NumericFns <T extends Number> { // O Argumento de tipo deve ser Number
    // ou uma sub-classe de Number


    T numero;

    // Passa para o construtor uma referencia
    // a um objeto numerico
    NumericFns (T n) {
        numero = n;
    }


    T getNumero(){
        return numero;
    }

    // Retorna o reciproco
    double reciprocal(){
        return 1 / numero.doubleValue();
    }

    // Retorna o componente fracionario
    double fraction(){
        return numero.doubleValue() - numero.intValue();
    }
}
