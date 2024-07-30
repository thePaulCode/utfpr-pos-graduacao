

public class ControllerAluno {


	public void localC() {
	
		System.out.println("\nLocalC");

	}

	public void validarAluno(int ra, String nome) {

		ArmazenarAluno stella = new ArmazenarAluno();
		int pRa = ra;

		String pNome = nome;
		

		if (pRa < 10) {
			
			System.out.println("\nValor de RA deve ser maior que 10.");
			pRa = 20;
		} else {

			System.out.println("\nValor de RA Valido.");

			System.out.println("\nSolicitar ArmazenarAluno " + ra + " - " + nome);

			stella.localA();
			stella.armazenar(pRa, pNome);
		}
		

		
	}
}

