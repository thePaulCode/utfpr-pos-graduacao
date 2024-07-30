

public class Alunos {

	private String nome;

	private int ra;

	public Alunos(){
		nome = "Stella";
		ra = 7;

		System.out.println("\nAluno: " + nome + " Ra: " + ra);
	}

	public void encaminharAlunoPagamento(Alunos stella) {
		
		System.out.println("\nEncaminhar pagamento" );
		
		stella.receberPagamentoAluno();
		
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		
		return nome;
	}

	public void setRa(int ra) {

		this.ra = ra;
	}

	public int getRa() {

		return ra;
	}

}
