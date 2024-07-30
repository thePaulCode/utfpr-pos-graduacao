package Arquitetura.Persistencia.Entidades;

import java.util.Date;
import Atores.Paciente;
import java.util.List;

public class Consulta {

	private int id;

	private Date dataHora;

	private Paciente paciente;

	private Medico medico;

	private String medicacaoPrescrita;

	private ConsultaExame consultaExame;

	public boolean incluirConsulta(Date dataHora, Paciente paciente, Medico medico, String medicacaoPrescrita, ConsultaExame consultaExame) {
		return false;
	}

	public boolean editarConsulta(Date dataHora, Paciente paciente, Medico medico, String medicacaoPrescrita, ConsultaExame consultaExame) {
		return false;
	}

	public List<Consulta> pesquisarConsulta(String nomePaciente) {
		return null;
	}

	public List<Consulta> listarConsulta() {
		return null;
	}

	public boolean excluirConsulta(int id) {
		return false;
	}

}
