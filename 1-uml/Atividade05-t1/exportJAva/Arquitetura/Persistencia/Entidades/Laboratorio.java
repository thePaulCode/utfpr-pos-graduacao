package Arquitetura.Persistencia.Entidades;

import java.util.List;

public class Laboratorio {

	private int id;

	private String nomeLaboratorio;

	private Cidade cidade;

	public boolean incluirLaboratorio(String nomeLaboratorio, Cidade cidade) {
		return false;
	}

	public boolean editarLaboratorio(String nomeLaboratorio, Cidade cidade) {
		return false;
	}

	public boolean excluirLaboratorio(int id) {
		return false;
	}

	public List<Laboratorio> pesquisarLaboratorio(String nomeLaboratorio) {
		return null;
	}

	public List<Laboratorio> listarLaboratorios() {
		return null;
	}

}
