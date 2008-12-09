package br.edu.uepb.escolaDeIngles.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Mantém informações sobre a matrícula do aluno
 *
 */
public class Matricula implements Serializable {
	
	private static final long serialVersionUID = -3191091069420761116L;

	private int periodoAtual = 0;
	
	private Date dataDeMatricula;
	
	private Date dataDeConclusao;
	
	private Aluno aluno;

	/**
	 * @return the aluno
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

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