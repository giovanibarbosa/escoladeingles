/**
 * 
 */
package br.edu.uepb.escolaDeIngles.modelo;

import java.io.Serializable;

/**
 * Representa um aluno
 * 
 */
public class Aluno implements Serializable {

	private static final long serialVersionUID = -722126437620395111L;

	private String id;

	private String nome;

	private String endereco;

	private String telefone;

	private Matricula matricula;

	public Aluno() {
		matricula = new Matricula();
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the matricula
	 */
	public Matricula getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula
	 *            the matricula to set
	 */
	public void setMatricula(Matricula matricula) {
		if (matricula != null)
			this.matricula = matricula;
	}
	
	public boolean isMatriculado(){
		return getMatricula().getDataDeMatricula() != null && getMatricula().getDataDeConclusao() == null;
	}
}