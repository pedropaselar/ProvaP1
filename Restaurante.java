import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;


public class Restaurante {

	public static void main(String[] args) {

		Reserva[] Reserva = new Reserva[10]; 
		int Posicao = 0; 
		int Opcao; 		
		do {
			Opcao = parseInt(showInputDialog(gerarMenu()));
			if(Opcao < 1 || Opcao > 6) {
				showMessageDialog(null, "Opcao Valida");
			} else {
				switch(Opcao) {
				case 1:
					cadastrar(Reserva, Posicao);
					Posicao++;
					break;
				case 2 :
					pesquisar(Reserva,Posicao);
					break;
				case 3:
					listar(Reserva, Posicao);
					break;
					
				case 5 :
					Posicao = remover(Reserva, Posicao);
					break;
				}
			}
		} while(Opcao != 6);
		
	}
	
	public static void listar(Reserva[] reserva, int posicao) {
		String aux = " ";
		for(int i = 0; i< 5 ; i++) {
			aux += reserva[i].getDados()+"\n";
		}
		showMessageDialog(null, aux);
		
		
	}
	
	
	public static int localizarCPF(Reserva [] reserva, int posicao, String CPF) {
		int posicao_aux = -1; 
		for(int i = 0;  i < posicao; i++) {
			if(reserva[i].CPF.equalsIgnoreCase(CPF)) {
				posicao_aux = i;
				break;
			}
		}
		return posicao_aux;
		
	}
	
	
	public static void pesquisar(Reserva[] reserva, int posicao) {
		String CPF = showInputDialog("Digite o CPF");
		int posicao_aux = localizarCPF(reserva, posicao, CPF);
		if(posicao_aux == -1) { 
			showMessageDialog(null, CPF +" nao foi encontrado");
			} else {
				showMessageDialog(null, reserva[posicao_aux].getDados());
			}
		
	}
	
	
	
		
	public static void cadastrar(Reserva[] reserva, int posicao) {
		reserva[posicao] = new Reserva();
		reserva[posicao].Nome = showInputDialog("Nome do Cliente");
		reserva[posicao].CPF = showInputDialog("CPF/CNPJ do Cliente");
		reserva[posicao].Pagamento = parseInt(showInputDialog("Forma de Pagamento (1 à vista, 2 parcelado) "));
		
	}
	
	public static String gerarMenu() {
			String aux = "Restaurante SABOR SOFISTICADO\n";
			aux +="1. Reservar mesa\n";
			aux +="2. Pesquisar reserva\n";
			aux +="3. Imprimir reservas\n";
			aux +="4. Imprimir lista de espera\n";
			aux +="5. Cancelar reserva\n";
			aux +="6. Finalizar\n";
			return aux;
	}
	
	
	public static int remover (Reserva [] reserva, int posicao) {
		String CPF = showInputDialog("Informe o CPF/CNPJ da Reserva que sera cancelada");
		int posicao_aux = localizarCPF(reserva, posicao, CPF);
		if (posicao_aux == -1) {
			showMessageDialog(null, CPF+", nao foi encontrado");
		} else {
			for (int i = posicao_aux; i < posicao-1; i++) {
				reserva[i] = reserva[i+1];
			}
			posicao--;
			
		}
		return posicao_aux;
	}

}