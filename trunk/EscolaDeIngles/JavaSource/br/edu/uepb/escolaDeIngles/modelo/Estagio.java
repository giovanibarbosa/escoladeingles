package br.edu.uepb.escolaDeIngles.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Representa o estágio e informações vinculadas
 *
 */
public class Estagio implements Serializable {

	private static final long serialVersionUID = -4925265185977912778L;

	private int numero;
	
	private Date dataDoExame;

	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

	private List<Falta> faltas = new ArrayList<Falta>();

	public Estagio() {
	}

	public Estagio(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the avaliacoes
	 */
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	/**
	 * @param avaliacoes
	 *            the avaliacoes to set
	 */
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Estagio other = (Estagio) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	/**
	 * @return the faltas
	 */
	public List<Falta> getFaltas() {
		return faltas;
	}

	/**
	 * @param faltas
	 *            the faltas to set
	 */
	public void setFaltas(List<Falta> faltas) {
		this.faltas = faltas;
	}

	/**
	 * @return the dataDoExame
	 */
	public Date getDataDoExame() {
		return dataDoExame;
	}

	/**
	 * @param dataDoExame the dataDoExame to set
	 */
	public void setDataDoExame(Date dataDoExame) {
		this.dataDoExame = dataDoExame;
	}

}
