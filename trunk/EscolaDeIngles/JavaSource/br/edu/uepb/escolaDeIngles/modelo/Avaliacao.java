package br.edu.uepb.escolaDeIngles.modelo;

import java.io.Serializable;
import java.util.Date;

public strictfp class Avaliacao implements Serializable {
	
	private static final long serialVersionUID = -4179955218112286698L;

	private Date data;
	
	private long nota;

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
	 * @return the nota
	 */
	public long getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(long nota) {
		this.nota = nota;
	}

}
