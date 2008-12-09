package br.edu.uepb.escolaDeIngles.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Representa uma entrada de pagamento realizada pelo aluno 
 *
 */
public strictfp class Pagamento implements Serializable {

	private static final long serialVersionUID = -1710290818062590012L;

	private Date data;
	
	private long valor;
	
	private TipoDePagamento tipo;

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the valor
	 */
	public long getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(long valor) {
		this.valor = valor;
	}

	/**
	 * @return the tipo
	 */
	public TipoDePagamento getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoDePagamento tipo) {
		this.tipo = tipo;
	}
}
