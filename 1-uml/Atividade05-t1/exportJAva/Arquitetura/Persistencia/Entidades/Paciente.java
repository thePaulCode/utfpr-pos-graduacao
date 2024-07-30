package Arquitetura.Persistencia.Entidades;

import java.util.List;

public class Paciente {

	private int id;

	private String nomePaciente;

	private Cidade cidade;

	private String pressaoArterial;

	private float peso;

	private float altura;

	private Convenio convenioPaciente;

	public boolean incluirPaciente(String nomePaciente, Cidade cidade) {
		return false;
	}

	public boolean editarPaciente(String nomePaciente, Cidade cidade) {
		return false;
	}

	public boolean excluirPaciente(int id) {
		return false;
	}

	public boolean pesquisarPaciente(String nomePaciente) {
		return false;
	}

	public List<Paciente> listarPacientes() {
		return null;
	}

}
