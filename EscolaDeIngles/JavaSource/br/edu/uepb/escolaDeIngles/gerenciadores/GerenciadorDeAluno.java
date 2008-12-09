package br.edu.uepb.escolaDeIngles.gerenciadores;

/**
 * Interface padr�o para manuten��o de dados de alunos
 *
 */
public interface GerenciadorDeAluno {

	/**
	 * Remove todos os dados do sistema
	 */
	void zeraSistema();
	
	
	/**
	 * Cadastra um novo aluno
	 * @param nome
	 * @param endereco
	 * @param telefone
	 * @return
	 */
	String criaAluno(String nome, String endereco, String telefone);

	/**
	 * Remove um aluno a partir do ID
	 * @param id
	 */
	void removeAluno(String id);

	/**
	 * Modifica o atributo especificado do aluno, informado atrav�s do ID
	 * @param id
	 * @param atributo
	 * @param valor
	 */
	void modificaAluno(String id, String atributo, String valor);

	/**
	 * Recupera o valor do atributo especificado do aluno, informado a partir do ID
	 * @param id
	 * @param atributo
	 * @return
	 */
	String getAtributoDoAluno(String id, String atributo);
	
	/**
	 * Registra a matr�cula de um aluno
	 * @param id
	 * @param data
	 */
	void matriculaAluno(String id, String data);

	/**
	 * Encerra a matr�cula de um aluno.
	 * @param id
	 * @param data
	 */
	void encerraMatricula(String id, String data);

	/**
	 * Registra o pagamento de um aluno
	 * @param id
	 * @param tipoDePagamento
	 * @param data
	 * @param valor
	 */
	void inserePagamento(String id, String tipoDePagamento, String data, String valor);

	/**
	 * Promove um aluno para o est�gio superior
	 * @param id
	 */
	void promoveAluno(String id);

	/**
	 * Agenda exame para mudan�a de est�gio
	 * @param id
	 * @param data
	 */
	void agendaExame(String id, String data);

	/**
	 * Insere a nota do exame
	 * @param id
	 * @param nota
	 * @param data
	 */
	void insereNota(String id, long nota, String data);

	/**
	 * Recupera informa��o do relat�rio financeiro
	 * @param id
	 * @param data
	 * @param atributo
	 * @return
	 */
	String emiteRelatorioFinanceiro(String id, String data, String atributo);

	/**
	 * Recupera informa��o do hist�rico de pagamentos em um intervalo de datas.
	 * @param id
	 * @param dataDeInicio
	 * @param dataDeTermino
	 * @param posicao
	 * @param atributo
	 * @return
	 */
	String emiteHistoricoDePagamentos(String id, String dataDeInicio, String dataDeTermino, String posicao, String atributo);

	/**
	 * Registra a falta de um aluno
	 * @param id
	 * @param data
	 */
	void registraFalta(String id, String data);

}