package Arquitetura.Persistencia.Entidades;

import java.util.List;

public class Medico {

	private int id;

	private String nomeMedico;

	private EspecialidadeMedica especialidadeMedica;

	public boolean incluirMedico(String nomeMedico, EspecialidadeMedica especialidadeMedica) {
		return false;
	}

	public boolean editarMedico(String nomeMedico, EspecialidadeMedica especialidadeMedica) {
		return false;
	}

	public boolean excluirMedico(int id) {
		return false;
	}

	public List<Medico> pesquisarMedico(String nomeMedico) {
		return null;
	}

	public List<Medico> listarMedicos() {
		return null;
	}

}
