

public class InterfaceAluno {


	public void localI() {
	
		System.out.println("\nLocalI");

	}

	public void incluirAluno() {

		ControllerAluno stella = new ControllerAluno();

		int ra = 21;
		String nome = "Stella";

		System.out.println("\nIncluirAluno " + ra + " - " + nome);

		stella.localC();
		stella.validarAluno(ra, nome);
	}
}

