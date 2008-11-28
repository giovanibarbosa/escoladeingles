package br.edu.uepb.escolaDeIngles.gerenciadores;

public interface GerenciadorDeAluno {

	public void zeraSistema();
	
	public String criaAluno(String nome, String endereco, String telefone);

	public void removeAluno(String id);

	public void modificaAluno(String id, String atributo, String valor);

	public String getAtributoDoAluno(String id, String atributo);

}