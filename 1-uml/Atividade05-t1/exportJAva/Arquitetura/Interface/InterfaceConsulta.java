package Arquitetura.Interface;

import java.util.Date;
import Arquitetura.Persistencia.Entidades.Paciente;
import Arquitetura.Persistencia.Entidades.Medico;
import Arquitetura.Persistencia.Entidades.Convenio;
import Arquitetura.Persistencia.Entidades.ConsultaExame;

public class InterfaceConsulta {

	public boolean informarDadosConsulta(Date dataHora, Paciente paciente, Medico medico, Convenio convenioPaciente, String medicacaoPrescrita, ConsultaExame consultaExame) {
		return false;
	}

}
