package Arquitetura.Persistencia.Entidades;

import java.util.List;

public class Exame {

	private int id;

	private String descricaoExame;

	private List<Laboratorio> laboratorio;

	public boolean incluirExame(String descricaoExame, Laboratorio laboratorio) {
		return false;
	}

	public boolean alterarExame(String descricaoExame, Laboratorio laboratorio) {
		return false;
	}

	public boolean excluirExame(String descricaoExame, Laboratorio laboratorio) {
		return false;
	}

	public boolean pesquisarExame(String descricaoExame, Laboratorio laboratorio) {
		return false;
	}

	public List<Exame> listarExame() {
		return null;
	}

}
