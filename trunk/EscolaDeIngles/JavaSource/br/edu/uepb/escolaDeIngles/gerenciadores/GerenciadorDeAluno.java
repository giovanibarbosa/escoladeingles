package br.edu.uepb.escolaDeIngles.gerenciadores;

public interface GerenciadorDeAluno {

	void zeraSistema();
	
	String criaAluno(String nome, String endereco, String telefone);

	void removeAluno(String id);

	void modificaAluno(String id, String atributo, String valor);

	String getAtributoDoAluno(String id, String atributo);
	
	void matriculaAluno(String id, String data);

	void encerraMatricula(String id, String data);

}