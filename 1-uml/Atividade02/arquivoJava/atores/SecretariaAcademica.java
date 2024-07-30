
public class SecretariaAcademica {

	public SecretariaAcademica() {}

	public void solicitarMatricula(Alunos stella) {
				

		System.out.println("Solicita Matricula Aluna: " + stella.getNome() + " Ra: " + stella.getRa());

		stella.encaminharAlunoPagamento(stella);
		
	}

}
