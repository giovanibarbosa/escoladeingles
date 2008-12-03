package br.edu.uepb.escolaDeIngles.modelo;

import java.io.Serializable;
import java.util.Date;

public class Falta implements Serializable {
	
	private static final long serialVersionUID = 6557409879292342806L;

	private Date data;

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

}
