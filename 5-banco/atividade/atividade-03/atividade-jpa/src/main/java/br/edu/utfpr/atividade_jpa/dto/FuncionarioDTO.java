package br.edu.utfpr.atividade_jpa.dto;

public class FuncionarioDTO {
    private String nomeFuncionario;
    private String nomeDepto;

    public FuncionarioDTO(String nomeFuncionario, String nomeDepto) {
        this.nomeFuncionario = nomeFuncionario;
        this.nomeDepto = nomeDepto;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNomeDepto() {
        return nomeDepto;
    }

    public void setNomeDepto(String nomeDepto) {
        this.nomeDepto = nomeDepto;
    }

    @Override
    public String toString() {
        return "FuncionarioDTO{" +
                "nomeFuncionario='" + nomeFuncionario + '\'' +
                ", nomeDepto='" + nomeDepto + '\'' +
                '}';
    }
}
