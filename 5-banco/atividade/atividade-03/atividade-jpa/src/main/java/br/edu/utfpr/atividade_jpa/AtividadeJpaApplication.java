package br.edu.utfpr.atividade_jpa;

import br.edu.utfpr.atividade_jpa.dto.FuncionarioDTO;
import br.edu.utfpr.atividade_jpa.entity.Departamento;
import br.edu.utfpr.atividade_jpa.entity.Funcionario;
import br.edu.utfpr.atividade_jpa.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AtividadeJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AtividadeJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AtividadeJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FuncionarioService funcionarioService, DepartamentoService departamentoService){
		return args -> {
			log.info("");
			log.info("");
			log.info("========Listagem 1- Funcionario e Dependentes");

			Optional<Funcionario> funcionario = funcionarioService.findFuncionarioDependentes("Helen Roche", 0);
			if (funcionario.isPresent()) {
				log.info(funcionario.get().toString());
			} else {
				log.info("Funcionario não encontrado.");
			}

			log.info("");
			log.info("");
			log.info("========Listagem 2- Funcionario Por Departamento");

			Integer codDepto = 4;
			List<Funcionario> funcionarios = funcionarioService.findFuncionarioDepto(codDepto);
			if(!funcionarios.isEmpty()){
				funcionarios.forEach(f -> log.info(f.toString()));
			} else {
				log.info("Nenhum funcionario encontrado no Departamenento com codigo: " + codDepto);
			}

			log.info("");
			log.info("");
			log.info("========Listagem 3- Primeiro Departamento Cadastrado");
			Departamento firstDepartamento = departamentoService.findFirstDepartamento();
			log.info(firstDepartamento.toString());

			log.info("");
			log.info("");
			log.info("========Listagem 4- Funcionario Maior Salario");

			Optional<Funcionario> funcionarioMaiorSalario = funcionarioService.findTopFuncionarioByMaiorSalario();
			if(funcionarioMaiorSalario.isPresent()){
				log.info(funcionarioMaiorSalario.get().toString());
			} else {
				log.info("Nenhum funcionario encontrado.");
			}

			log.info("");
			log.info("");
			log.info("========Listagem 5- Funcionario Maior Salario");

			for (Funcionario fSalario : funcionarioService.findFirst3FuncionarioByMaiorSalario()) {

				log.info(fSalario.toString());
			}

			log.info("");
			log.info("");
			log.info("========Listagem 6- Funcionario Sem Dependentes");
			List<Funcionario> fSemDependentes = funcionarioService.findFuncionarioZeroDependentes();
			if(!fSemDependentes.isEmpty()){
				fSemDependentes.forEach(fs -> log.info(fs.toString()));
			} else{
				log.info("Nenhum funcionario encontrado no Departamenento com zero dependentes.");

			}

			log.info("");
			log.info("");
			log.info("========Listagem 7- Funcionario Por Salario");
			Float salario = 7999.0F;
			List<Funcionario> fSalario = funcionarioService.findFuncionarioSalario(salario);

			if(!fSalario.isEmpty()){
				fSalario.forEach(f -> log.info(f.toString()));
			} else{
				log.info("Nenhum funcionario encontrado com o salario especificado.");

			}

			log.info("");
			log.info("");
			log.info("========Listagem 8- Funcionario Por Salario NativeQuery");
			Float sal = 5999.0F;
			List<Funcionario> fSalarioNQ = funcionarioService.findSalario(sal);

			if(!fSalarioNQ.isEmpty()){
				fSalarioNQ.forEach(f -> log.info(f.toString()));
			} else{
				log.info("Nenhum funcionario encontrado com o salario especificado.");

			}

			log.info("");
			log.info("");
			log.info("========Listagem 9- Funcionario Por Numero de Dependentes");
			Integer numeroDependentes = 3;
			List<Funcionario> fDependentes = funcionarioService.findFuncionarioPorDependentes(numeroDependentes);

			if(!fDependentes.isEmpty()){
				fDependentes.forEach(f -> log.info(f.toString()));
			} else{
				log.info("Nenhum funcionario encontrado com a quantidade de dependentes especificada.");

			}

			log.info("");
			log.info("");
			log.info("========Listagem 10- Funcionario Por Parte do Nome");
			String parteNome = "roc";
			List<Funcionario> funcionarioPorNome = funcionarioService.findFuncionarioPorNome(parteNome);

			if(!funcionarioPorNome.isEmpty()){
				funcionarioPorNome.forEach(f -> log.info(f.toString()));
			} else{
				log.info("Nenhum funcionario encontrado com a parte do nome especificado.");
			}

			log.info("");
			log.info("");
			log.info("========Atividade 5-1 - Aumentar Salario de Todos Funcionarios");
			int porcentagemAumento = 0;
			List<Funcionario> buscarTodosFuncionarios = funcionarioService.buscarTodos();
			if(!buscarTodosFuncionarios.isEmpty()){
				funcionarioService.aumentarSalario(porcentagemAumento);

				log.info("Aumento realizado com sucesso.");
				buscarTodosFuncionarios = funcionarioService.buscarTodos();
				buscarTodosFuncionarios.forEach(f -> log.info(f.toString()));
			} else {
				log.info("Nenhum funcionario encontrado.");

			}


			log.info("");
			log.info("");
			log.info("========Atividade 5-2 - Todos Funcionarios departamento que não possuem dependentes");
			final String departamento = "Financas";
			List<Funcionario> listaFuncionarioDepto = funcionarioService.buscarFuncionarioSemDependentesPorDepartamento(departamento);

			if(!listaFuncionarioDepto.isEmpty()){
				listaFuncionarioDepto.forEach(f -> log.info(f.toString()));
			} else {
				log.info("Nenhum funcionario encontrado sem dependentes nesse departamento %s.".formatted(departamento));
			}
//			log.info("");
//			log.info("");
//			log.info("========Atividade 5-3 - UPDATE Troca de Departamento");
//
//			final String deptoOrigem = "Marketing";
//			final String deptoDestino = "Recursos Humanos";
//			log.info("\tAtualizar Funcionarios do Depto: %s, para o Depto: %s".formatted(deptoOrigem, deptoDestino));
//
//			funcionarioService.atualizarFuncionarioDeptoParaOutro(deptoOrigem, deptoDestino);
//
//			log.info("Atulizado com sucesso!");
//			log.info("");
//			log.info("========Atividade 5-4 - Excluir Todos de um Departamento");
//			final String depto = "";
//
//			log.info("========Listagem Antes da Exclusao");
//
//			List<Funcionario> buscarTodosFuncionarios2 = funcionarioService.buscarTodos();
//			if(!buscarTodosFuncionarios2.isEmpty()) {
//				buscarTodosFuncionarios2.forEach(f -> log.info(f.toString()));
//				log.info("");
//				try {
//					funcionarioService.excluirFuncionarioPorDepto(depto);
//
//				} catch (NullPointerException ex){
//					log.info("Departamento nao cadastrado.");
//				}
//			} else {
//				log.info("Nenhum funcionario encontrado.");
//
//			}
//
//			log.info("========Listagem Apos da Exclusao");
//
//			List<Funcionario> buscarTodosFuncionarios3= funcionarioService.buscarTodos();
//			if(!buscarTodosFuncionarios3.isEmpty()) {
//				buscarTodosFuncionarios3.forEach(f -> log.info(f.toString()));
//
//			} else {
//				log.info("Nenhum funcionario encontrado.");
//
//			}

			log.info("");
			log.info("");
			log.info("========Atividade 5-5 - Transacao Salvar Departamento e Funcionario");
			log.info("Adicionar Departamento:");
			final Departamento depto1 = new Departamento();
			depto1.setCodDepto(5);
			depto1.setNomeDepto("Seguranca Juridica");

			log.info("Adicionar Funcionario:");
			final Funcionario funcionario1 = new Funcionario();
			funcionario1.setCodFuncionario(10);
			funcionario1.setNomeFuncionario("Stella S");
			funcionario1.setCargo("Advogada");
			funcionario1.setSalario(9899.0F);
			funcionario1.setQtdeDependentes(0);

			log.info("Finalizar Transacao");
			log.info("Salvar a Funcionaria %s no Depto %s".formatted(funcionario1.getNomeFuncionario(), depto1.getNomeDepto()));

			try {
				departamentoService.salvarDeptoTransacao(depto1, funcionario1);
			} catch (NullPointerException ex){
				ex.getMessage();
			}


			log.info("======== Todos Funcionarios ========");

			List<Funcionario> buscarTodosFuncionariosT = funcionarioService.buscarTodos();
			if(!buscarTodosFuncionariosT.isEmpty()){

				buscarTodosFuncionariosT.forEach(f -> log.info(f.toString()));
			} else {
				log.info("Nenhum funcionario encontrado.");

			}

		};
	}
}
