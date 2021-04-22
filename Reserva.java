
public class Reserva {
	String Nome;
	String CPF;
	String Telefone;
	int Pagamento;
	
	public double calcularPagamento() {
		if(Pagamento == 1) {
			return  2880;
		} else {
			return  3680;
		} 
	}
	
	public String getDados() {
		String aux = "";
		aux += "Nome --> "+Nome+"\n";
		aux +="CPF --> "+CPF+"\n";
		aux +="Telefone --> "+Telefone+"\n";
		aux +="Pagamento --> "+getTipoPagamento()+"\n";
		aux +="Valor a Pagar --> R$"+(calcularPagamento())+"\n";
		return aux;
	}

	public String getTipoPagamento(){
		if (Pagamento == 1) {
			return "A Vista";
		} else {
			return "Parcelado";
		}
	}

}

