/**
 * 
 */
package br.edu.uepb.escolaDeIngles.acessoADados;

import java.io.IOException;

import br.edu.uepb.escolaDeIngles.modelo.Aluno;


/**
 *
 * Interface de acesso a dados para aluno
 *
 */
public interface AcessoADadosDeAluno {

	public void salva(Aluno aluno) throws IOException;
	
	public void remove(String id) throws IOException;
	
	public Aluno obtem(String id);

	public void removeTodos() throws IOException;
	
}
