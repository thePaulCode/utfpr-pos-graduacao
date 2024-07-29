package dev.thepaulcode.generico.tipogen;

import dev.thepaulcode.generico.tipogen.Generico;

public class GenericoApp {

    public static void main(String[] args) {

        // Cria uma referencia Generico para Integer
        Generico<Integer> iOb;

        //
        iOb = new Generico<>(21);

        // Exibe o tipo de dado usado por iOb
        iOb.showType();

        // Obtem o valor de iOb
        // sem necessidade de coercao
        int valoriOb = iOb.getOb();
        System.out.println("\tO Valor de iOb -> " + valoriOb);

        // Cria um objeto Generico para String
        Generico<String> stringOb = new Generico<>("Teste Generico String");

        stringOb.showType();

        String valorstringOb = stringOb.getOb();
        System.out.println("\tO Conteudo da String -> " + valorstringOb);
    }
}