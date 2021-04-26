
public class Reserva {
	String Nome;
	String CPF;
	int Pagamento;
	
	public double calcularPagamento() {
		if(Pagamento == 1) {
			return  2880;
		} else {
			return  3200;
		} 
	}
	
	public String getDados() {
		String aux = "";
		aux += "Nome --> "+Nome+"\n";
		aux +="CPF/CNPJ --> "+CPF+"\n";
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

