/**
 * 
 */
package br.edu.uepb.escolaDeIngles.acessoADados;

import br.edu.uepb.escolaDeIngles.modelo.Aluno;

/**
 * Interface de acesso a dados para aluno
 */
public interface AcessoADadosDeAluno {

	public void salva(Aluno aluno);
	
	public void remove(String id);
	
	public Aluno obtem(String id);

	public void removeTodos();
	
}
