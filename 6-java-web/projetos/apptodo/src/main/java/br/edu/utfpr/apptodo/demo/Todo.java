package br.edu.utfpr.apptodo.demo;

public record Todo(Long ig, String titulo, String descricao, boolean feito) {

    public Todo {
        if((titulo == null) || (titulo.length() < 3)){
            throw new IllegalArgumentException("Um título deve conter mais que 3 caracteres.");
        }
    }
}
