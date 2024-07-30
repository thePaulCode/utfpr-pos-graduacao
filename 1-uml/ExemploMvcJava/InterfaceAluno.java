public class InterfaceAluno {

	public String nome;

	public int Ra;

	public void LocalI() {

		System.out.println("\n\tInterfaceAluno");
	}

	public void Inserir() {

		ValidaAluno Pele = new ValidaAluno();
		System.out.println("\n\tInsercao de Dados");
		nome = "Pele";
		Ra = 30;

		System.out.println("\n"+nome);
		System.out.println("\n"+Ra);

		Pele.LocalV();
		Pele.validar(Ra, nome);

		

	}
	
}