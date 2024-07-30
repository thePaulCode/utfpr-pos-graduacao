package Arquitetura.Persistencia.Entidades;

import java.util.List;

public class Relatorio {

	private int id;

	private Paciente paciente;

	private Medico medico;

	private Consulta consulta;

	public boolean incluirRelatorio(Medico medico, Paciente paciente, Consulta consulta) {
		return false;
	}

	public boolean editarRelatorio(Medico medico, Paciente paciente, Consulta consulta) {
		return false;
	}

	public boolean excluirRelatorio(int id, Consulta consulta) {
		return false;
	}

	public List_Relatorio_ consultarRelatorio(Medico medico, Paciente paciente, Consulta consulta) {
		return null;
	}

}
