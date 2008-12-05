/**
 * 
 */
package br.edu.uepb.escolaDeIngles.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um aluno
 * 
 */
public class Aluno implements Serializable {

	private static final long serialVersionUID = 4497027761186147373L;

	private String id;

	private String nome;

	private String endereco;

	private String telefone;

	private Matricula matricula;

	private List<Estagio> estagios = new ArrayList<Estagio>();

	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();

	private Estagio estagioAtual;

	public Aluno() {
		estagios.add(new Estagio(1));
		estagios.add(new Estagio(2));
		estagios.add(new Estagio(3));
		estagios.add(new Estagio(4));
		estagios.add(new Estagio(5));
		estagios.add(new Estagio(6));
		estagios.add(new Estagio(7));
		estagios.add(new Estagio(8));
		estagioAtual = estagios.get(0);
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

	public boolean isMatriculado() {
		return getMatricula().getDataDeMatricula() != null
				&& getMatricula().getDataDeConclusao() == null;
	}

	/**
	 * @return the pagamentos
	 */
	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	/**
	 * @param pagamentos
	 *            the pagamentos to set
	 */
	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	/**
	 * @return the estagioAtual
	 */
	public Estagio getEstagioAtual() {
		return estagioAtual;
	}

	public void setEstagioAtual(Estagio estagioAtual) {
		this.estagioAtual = estagioAtual;
	}

	/**
	 * @return the estagios
	 */
	public List<Estagio> getEstagios() {
		return estagios;
	}

	/**
	 * @param estagios
	 *            the estagios to set
	 */
	public void setEstagios(List<Estagio> estagios) {
		this.estagios = estagios;
	}

}