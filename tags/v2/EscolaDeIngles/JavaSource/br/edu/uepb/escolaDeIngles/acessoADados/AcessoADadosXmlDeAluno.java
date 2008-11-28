package br.edu.uepb.escolaDeIngles.acessoADados;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.uepb.escolaDeIngles.modelo.Aluno;

/**
 * 
 * Implementação de persistência em XML para acesso a dados de aluno
 * 
 */
public class AcessoADadosXmlDeAluno extends AcessoADadosXml implements AcessoADadosDeAluno {

	private static Log log = LogFactory.getLog(AcessoADadosXmlDeAluno.class);
	
	public AcessoADadosXmlDeAluno() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see acessoADados.AlunoDao#obtem(int)
	 */
	@Override
	public Aluno obtem(String id) {
		log.debug("Parâmetros: " + id);
		return alunos.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see acessoADados.AlunoDao#remove(int)
	 */
	@Override
	public void remove(String id) {
		alunos.remove(id);
		salvaParaDisco(alunos);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see acessoADados.AlunoDao#salva(modelo.Aluno)
	 */
	@Override
	public void salva(Aluno aluno) {
		if (aluno.getId() == null) {
			aluno.setId(UUID.randomUUID().toString());
			alunos.put(aluno.getId(), aluno);
		}
		salvaParaDisco(alunos);
	}

	@Override
	public void removeTodos() {
		reiniciaBase();
	}

}
