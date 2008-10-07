/**
 * 
 */
package acessoADados;

import java.io.IOException;

import modelo.Aluno;

/**
 *
 * Interface de acesso a dados para aluno
 *
 */
public interface AlunoDao {

	public void salva(Aluno aluno) throws IOException;
	
	public void remove(String id) throws IOException;
	
	public Aluno obtem(String id);

	public void removeTodos() throws IOException;
	
}
