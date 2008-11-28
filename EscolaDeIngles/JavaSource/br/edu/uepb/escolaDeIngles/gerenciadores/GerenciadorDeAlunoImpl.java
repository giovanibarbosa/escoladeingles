package br.edu.uepb.escolaDeIngles.gerenciadores;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.uepb.escolaDeIngles.acessoADados.AcessoADadosDeAluno;
import br.edu.uepb.escolaDeIngles.modelo.Aluno;

public class GerenciadorDeAlunoImpl implements GerenciadorDeAluno {

	private static Log log = LogFactory.getLog(GerenciadorDeAlunoImpl.class);
	
	private AcessoADadosDeAluno acessoADadosDeAluno;

	/**
	 * @param acessoADadosDeAluno
	 *            the acessoADadosDeAluno to set
	 */
	public void setAcessoADadosDeAluno(AcessoADadosDeAluno acessoADadosDeAluno) {
		this.acessoADadosDeAluno = acessoADadosDeAluno;
	}

	@Override
	public void zeraSistema() {
		acessoADadosDeAluno.removeTodos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uepb.escolaDeIngles.gerenciadores.GerenciadorDeAluno#criaAluno(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public String criaAluno(String nome, String endereco, String telefone) {
		log.debug("Patr�metros: " + nome + ", " + endereco + ", " + telefone);
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setEndereco(endereco);
		aluno.setTelefone(telefone);

		acessoADadosDeAluno.salva(aluno);
		
		log.debug("ID gerado: " + aluno.getId());
		return aluno.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uepb.escolaDeIngles.gerenciadores.GerenciadorDeAluno#removeAluno(java.lang.String)
	 */
	public void removeAluno(String id) {
		log.debug("Par�metro: " + id);
		
		acessoADadosDeAluno.remove(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uepb.escolaDeIngles.gerenciadores.GerenciadorDeAluno#modificaAluno(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public void modificaAluno(String id, String atributo, String valor) {
		log.debug("Par�metros :" + id + ", " + atributo + ", " + valor);
		
		Aluno aluno = getAluno(id);
		try {
			BeanUtils.setProperty(aluno, atributo, valor);
		} catch (IllegalAccessException e) {
			log.error("Acesso ilegal",e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (InvocationTargetException e) {
			log.error("Erro de invoca��o", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch(Throwable e){
			log.error("Problema n�o tratado.", e);
			throw new ImpossivelExecutarMetodoException(e);
		}
		acessoADadosDeAluno.salva(aluno);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uepb.escolaDeIngles.gerenciadores.GerenciadorDeAluno#getAtributoDoAluno(java.lang.String,
	 *      java.lang.String)
	 */
	public String getAtributoDoAluno(String id, String atributo) {
		log.debug("Par�metros " + id + ", " + atributo);
		
		Aluno aluno = getAluno(id);
		try {
			String valorDeRetorno = BeanUtils.getProperty(aluno, atributo);
			
			log.debug("Valor retornado: " + valorDeRetorno);
			
			return valorDeRetorno;
		} catch (IllegalAccessException e) {
			log.error("Acesso ilegal",e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (InvocationTargetException e) {
			log.error("Erro de invoca��o", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (NoSuchMethodException e) {
			log.error("M�todo n�o existe", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch(Throwable e){
			log.error("Problema n�o tratado.", e);
			throw new ImpossivelExecutarMetodoException(e);
		}
	}

	private Aluno getAluno(String id) {
		Aluno aluno = acessoADadosDeAluno.obtem(id);
		if (aluno == null) {
			throw new ObjetoNaoEncontradoException("Aluno n�o cadastrado.");
		}
		return aluno;
	}
}
