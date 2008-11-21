package br.edu.uepb.escolaDeIngles.modelo;

import java.io.Serializable;
import java.util.Date;

public class Matricula implements Serializable {
	
	private static final long serialVersionUID = -3864844780342879199L;

	private int periodoAtual = 0;
	
	private Date dataDeMatricula;
	
	private Date dataDeConclusao;

	/**
	 * @return the periodoAtual
	 */
	public int getPeriodoAtual() {
		return periodoAtual;
	}

	/**
	 * @param periodoAtual the periodoAtual to set
	 */
	public void setPeriodoAtual(int periodoAtual) {
		this.periodoAtual = periodoAtual;
	}

	/**
	 * @return the dataDeMatricula
	 */
	public Date getDataDeMatricula() {
		return dataDeMatricula;
	}

	/**
	 * @param dataDeMatricula the dataDeMatricula to set
	 */
	public void setDataDeMatricula(Date dataDeMatricula) {
		this.dataDeMatricula = dataDeMatricula;
	}

	/**
	 * @return the dataDeConclusao
	 */
	public Date getDataDeConclusao() {
		return dataDeConclusao;
	}

	/**
	 * @param dataDeConclusao the dataDeConclusao to set
	 */
	public void setDataDeConclusao(Date dataDeConclusao) {
		this.dataDeConclusao = dataDeConclusao;
	}
	
	
}
