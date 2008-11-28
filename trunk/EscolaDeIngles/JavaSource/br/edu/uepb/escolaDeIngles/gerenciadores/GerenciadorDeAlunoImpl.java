package br.edu.uepb.escolaDeIngles.gerenciadores;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.uepb.escolaDeIngles.acessoADados.AcessoADadosDeAluno;
import br.edu.uepb.escolaDeIngles.modelo.Aluno;
import br.edu.uepb.escolaDeIngles.modelo.Pagamento;
import br.edu.uepb.escolaDeIngles.modelo.TipoDePagamento;

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

		Aluno aluno = getAluno(id);
		log.debug("Aluno est� matriculado: " + aluno.isMatriculado());
		if (aluno.isMatriculado()) {
			log.debug("Aluno est� matriculado e n�o pode ser removido.");
			throw new ImpossivelExecutarMetodoException(
					"Aluno n�o pode ser removido enquanto estiver matriculado.");
		}
		log.debug("Concluindo remo��o.");
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
			log.error("Acesso ilegal", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (InvocationTargetException e) {
			log.error("Erro de invoca��o", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (Throwable e) {
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
			String retorno = BeanUtils.getProperty(aluno, atributo);
			return retorno != null ? retorno.toString() : "";
		} catch (IllegalAccessException e) {
			log.error("Acesso ilegal", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (InvocationTargetException e) {
			log.error("Erro de invoca��o", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (NoSuchMethodException e) {
			log.error("M�todo n�o existe", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (Throwable e) {
			log.error("Problema n�o tratado.", e);
			throw new ImpossivelExecutarMetodoException(e);
		}
	}

	private Aluno getAluno(String id) {
		log.debug("Par�metros: " + id);
		Aluno aluno = acessoADadosDeAluno.obtem(id);
		if (aluno == null) {
			throw new ObjetoNaoEncontradoException("Aluno n�o cadastrado.");
		}
		return aluno;
	}

	@Override
	public void matriculaAluno(String id, String data) {
		Aluno aluno = acessoADadosDeAluno.obtem(id);
		
		if(aluno.isMatriculado()){
			throw new ImpossivelExecutarMetodoException("Aluno n�o pode ser matriculado. Este j� encontra-se matriculado.");
		}
		
		Date dataEscolhida = converteStringParaData(data);

		aluno.getMatricula().setDataDeMatricula(dataEscolhida);

		acessoADadosDeAluno.salva(aluno);
	}

	@Override
	public void encerraMatricula(String id, String data) {
		Aluno aluno = acessoADadosDeAluno.obtem(id);
		
		if(!aluno.isMatriculado()){
			throw new ImpossivelExecutarMetodoException("Aluno n�o pode ter matricula encerrada se n�o est� matriculado.");
		}
		
		Date dataEscolhida = converteStringParaData(data);
		aluno.getMatricula().setDataDeConclusao(dataEscolhida);
		acessoADadosDeAluno.salva(aluno);
	}

	/**
	 * @param data
	 * @param dataEscolhida
	 * @return
	 */
	private Date converteStringParaData(String data) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			log.error("Data inv�lida", e);
			throw new ImpossivelExecutarMetodoException("Data inv�lida");
		}
	}

	@Override
	public void inserePagamento(String id, String tipoDePagamento, String data, String valor) {
		Aluno aluno = getAluno(id);
		if (!aluno.isMatriculado()){
			throw new ImpossivelExecutarMetodoException("N�o � poss�vel registrar pagamento para um aluno n�o matriculado");
		}
		
		Pagamento pagamento = new Pagamento();
		pagamento.setTipo(Enum.valueOf(TipoDePagamento.class, tipoDePagamento));
		pagamento.setData(converteStringParaData(data));
		pagamento.setValor(new Double(valor));
		aluno.getPagamentos().add(pagamento);
	}
}
