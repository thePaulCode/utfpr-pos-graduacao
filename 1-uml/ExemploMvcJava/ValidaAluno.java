public class ValidaAluno {

	ArmazenarAluno Pele = new ArmazenarAluno();

	public void LocalV() {

		System.out.println("\n\tValidaAluno");
	}

	public void validar(int pRa, String nome) {
		
		if(pRa >=30) {
			
			System.out.println("\n\tRa Valido");

		} else {

			System.out.println("\n\tRa Invalido");

		}
		
		Pele.armazenar(pRa, nome);

	}

	
	
}