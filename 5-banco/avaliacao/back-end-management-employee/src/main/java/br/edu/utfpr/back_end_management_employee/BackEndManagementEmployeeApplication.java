package br.edu.utfpr.back_end_management_employee;

import br.edu.utfpr.back_end_management_employee.entity.Cargo;
import br.edu.utfpr.back_end_management_employee.entity.Funcionario;
import br.edu.utfpr.back_end_management_employee.service.CargoService;
import br.edu.utfpr.back_end_management_employee.service.FuncionarioService;
import jakarta.websocket.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class BackEndManagementEmployeeApplication {

	private static final Logger log = LoggerFactory.getLogger(BackEndManagementEmployeeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackEndManagementEmployeeApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(CargoService cargoService, FuncionarioService funcionarioService) {
		return args -> {

			/**
			 *
			  * Excluir pelo menos 1 Cargo pelo identificador (*1); e
			 * Excluir pelo menos 1 Funcionário pelo identificador (*1).
			 *
			 *
			 *
			 * Listar todos os Funcionários;
			 * Listar todos os Cargos;
			 * Listar os Funcionários em Ordem Alfabética; e
			 * Listar a Quantidade de Funcionários.
			 *
			 *
			 *
//			 * */
			log.info("");
			log.info("");
			log.info("========Listagem 1- Inserir Cargos");
			final List<Cargo> cargoList = List.of(
					new Cargo("Vigilante"),
					new Cargo("Engenheiro de Dados"),
					new Cargo("Gerente de Vendas")

			);
			cargoList.forEach(cargoService::salvar);
			log.info("Cargos adicionados");
			log.info("");
			log.info("");
			log.info("========Listagem 2- Inserir Funcionarios");

			final List<Funcionario> funcionarioList = List.of(
					new Funcionario("Stella Artois", "Feminino", "4444-0000", cargoList.get(0)),
					new Funcionario("Arnold Schwarzenegger", "Masculino", "5544-0000", cargoList.get(1)),
					new Funcionario("Paulaner Berger", "Feminino", "6644-0000", cargoList.get(2))
			);
			funcionarioList.forEach(funcionarioService::salvar);
			log.info("Funcionarios adicionados");

			log.info("");
			log.info("");
			log.info("========Listagem 3- Excluir Funcionario pelo identificador");
			final Integer idFuncionario = 1;
			try {
				funcionarioService.excluir(idFuncionario);
				log.info("Funcionario id=%s excluido.".formatted(idFuncionario));
			} catch (NullPointerException ex){
				log.info("Funcionario nao encontrado.");
			}
			log.info("");
			log.info("");
			log.info("========Listagem 4- Excluir Cargo pelo identificador");
			final Integer idCargo = 2;
			try {
				cargoService.excluir(idCargo);
				log.info("Cargo id=%s excluido.".formatted(idCargo));
			} catch (NullPointerException ex){
				log.info("Cargo nao encontrado.");
			}
			log.info("");
			log.info("");
			log.info("========Listagem 5- Listar Todos Funcionarios");
			List<Funcionario> funcionarios = funcionarioService.listarTodos();
			if (!funcionarios.isEmpty()){
				funcionarios.forEach(f -> log.info(f.toString()));
			}else{
				log.info("Nenhum Funcionario Cadastrado.");

			}
			log.info("");
			log.info("");
			log.info("========Listagem 6- Listar Todos Cargos");
			List<Cargo> cargos = cargoService.listarTodos();
			if (!cargos.isEmpty()){
				cargos.forEach(c -> log.info(c.toString()));
			}else{
				log.info("Nenhum Cargo Cadastrado.");

			}
			log.info("");
			log.info("");
			log.info("========Listagem 7- Listar Todos Funcionarios Ordem Alfabetica");
			List<Funcionario> funcionariosOrdenados = funcionarioService.listarTodosOrdemCrescente();
			if (!funcionariosOrdenados.isEmpty()){
				funcionariosOrdenados.forEach(f -> log.info(f.toString()));
			}else{
				log.info("Nenhum Funcionario Cadastrado.");

			}
			log.info("");
			log.info("");
			log.info("========Listagem 8- Listar Quantidade de Funcionarios");
			final int totalFuncionarios = funcionarioService.quantidadeFuncionarios();
			log.info("Total de Funcionarios: %s".formatted(totalFuncionarios));



		};
	}
}
