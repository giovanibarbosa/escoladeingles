/**
 * 
 */
package br.edu.uepb.escolaDeIngles.acessoADados;

import java.io.IOException;
import java.util.UUID;

import br.edu.uepb.escolaDeIngles.modelo.Aluno;

/**
 * 
 * Implementação de persistência em XML para acesso a dados de aluno
 * 
 */
public class AcessoADadosXmlDeAluno extends AcessoADadosXml implements AcessoADadosDeAluno{

	protected AcessoADadosXmlDeAluno() throws IOException {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see acessoADados.AlunoDao#obtem(int)
	 */
	@Override
	public Aluno obtem(String id) {
		return alunos.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see acessoADados.AlunoDao#remove(int)
	 */
	@Override
	public void remove(String id) throws IOException {
		alunos.remove(id);
		salvaParaDisco(alunos);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see acessoADados.AlunoDao#salva(modelo.Aluno)
	 */
	@Override
	public void salva(Aluno aluno) throws IOException {
		aluno.setId(UUID.randomUUID().toString());
		alunos.put(aluno.getId(), aluno);
		salvaParaDisco(alunos);
	}

	@Override
	public void removeTodos() throws IOException {
		reiniciaBase();
	}

}
