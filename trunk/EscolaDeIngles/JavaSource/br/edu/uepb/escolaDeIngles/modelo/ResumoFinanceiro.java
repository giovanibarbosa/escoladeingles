package br.edu.uepb.escolaDeIngles.modelo;

/**
 * Objeto para transferência de dados, representando o resumo financeiro de uma consulta
 * @author Rodrigo
 *
 */
public strictfp class ResumoFinanceiro {

	private long valorPago;
	
	private long valorDevido;

	/**
	 * @return the valorPago
	 */
	public long getValorPago() {
		return valorPago;
	}

	/**
	 * @param valorPago the valorPago to set
	 */
	public void setValorPago(long valorPago) {
		this.valorPago = valorPago;
	}

	/**
	 * @return the valorDevido
	 */
	public long getValorDevido() {
		return valorDevido;
	}

	/**
	 * @param valorDevido the valorDevido to set
	 */
	public void setValorDevido(long valorDevido) {
		this.valorDevido = valorDevido;
	}
}
