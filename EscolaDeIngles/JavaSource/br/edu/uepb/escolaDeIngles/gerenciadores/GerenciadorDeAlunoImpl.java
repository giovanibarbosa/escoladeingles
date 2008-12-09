package br.edu.uepb.escolaDeIngles.gerenciadores;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.uepb.escolaDeIngles.acessoADados.AcessoADadosDeAluno;
import br.edu.uepb.escolaDeIngles.modelo.Aluno;
import br.edu.uepb.escolaDeIngles.modelo.Avaliacao;
import br.edu.uepb.escolaDeIngles.modelo.Falta;
import br.edu.uepb.escolaDeIngles.modelo.Pagamento;
import br.edu.uepb.escolaDeIngles.modelo.ResumoFinanceiro;
import br.edu.uepb.escolaDeIngles.modelo.TipoDePagamento;

/**
 * Implementação padrão para o GerenciadorDeAluno
 *
 */
public strictfp class GerenciadorDeAlunoImpl implements GerenciadorDeAluno {

	private long VALOR_DA_MENSALIDADE = 150; 
	
	private int TOTAL_DE_AULAS_POR_ESTAGIO = 30;
	
	private long PORCENTAGEM_PEMITIDA_DE_FALTAS = 25; // 75,0 % de presença
	
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
		log.debug("Patrâmetros: " + nome + ", " + endereco + ", " + telefone);

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
		log.debug("Parâmetro: " + id);

		Aluno aluno = getAluno(id);
		log.debug("Aluno está matriculado: " + aluno.isMatriculado());
		if (aluno.isMatriculado()) {
			log.debug("Aluno está matriculado e não pode ser removido.");
			throw new ImpossivelExecutarMetodoException(
					"Aluno não pode ser removido enquanto estiver matriculado.");
		}
		log.debug("Concluindo remoção.");
		acessoADadosDeAluno.remove(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uepb.escolaDeIngles.gerenciadores.GerenciadorDeAluno#modificaAluno(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public void modificaAluno(String id, String atributo, String valor) {
		log.debug("Parâmetros :" + id + ", " + atributo + ", " + valor);

		Aluno aluno = getAluno(id);
		try {
			BeanUtils.setProperty(aluno, atributo, valor);
		} catch (IllegalAccessException e) {
			log.error("Acesso ilegal", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (InvocationTargetException e) {
			log.error("Erro de invocação", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (Throwable e) {
			log.error("Problema não tratado.", e);
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
		log.debug("Parâmetros " + id + ", " + atributo);

		Aluno aluno = getAluno(id);
		return getAtributo(atributo, aluno);
	}

	private <T> String getAtributo(String atributo, T object) {
		try {
			String retorno = BeanUtils.getProperty(object, atributo);
			return retorno != null ? retorno.toString() : "";
		} catch (IllegalAccessException e) {
			log.error("Acesso ilegal", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (InvocationTargetException e) {
			log.error("Erro de invocação", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (NoSuchMethodException e) {
			log.error("Método não existe", e);
			throw new ImpossivelExecutarMetodoException(e);
		} catch (Throwable e) {
			log.error("Problema não tratado.", e);
			throw new ImpossivelExecutarMetodoException(e);
		}
	}

	private Aluno getAluno(String id) {
		log.debug("Parâmetros: " + id);
		Aluno aluno = acessoADadosDeAluno.obtem(id);
		if (aluno == null) {
			throw new ObjetoNaoEncontradoException("Aluno não cadastrado.");
		}
		return aluno;
	}

	@Override
	public void matriculaAluno(String id, String data) {
		Aluno aluno = acessoADadosDeAluno.obtem(id);
		
		if(aluno.isMatriculado()){
			throw new ImpossivelExecutarMetodoException("Aluno não pode ser matriculado. Este já encontra-se matriculado.");
		}
		
		Date dataEscolhida = converteStringParaData(data);

		aluno.getMatricula().setDataDeMatricula(dataEscolhida);

		acessoADadosDeAluno.salva(aluno);
	}

	@Override
	public void encerraMatricula(String id, String data) {
		Aluno aluno = acessoADadosDeAluno.obtem(id);
		
		if(!aluno.isMatriculado()){
			throw new ImpossivelExecutarMetodoException("Aluno não pode ter matricula encerrada se não está matriculado.");
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
			log.error("Data inválida", e);
			throw new ImpossivelExecutarMetodoException("Data inválida");
		}
	}

	@Override
	public void inserePagamento(String id, String tipoDePagamento, String data, String valor) {
		Aluno aluno = getAluno(id);
		if (!aluno.isMatriculado()){
			throw new ImpossivelExecutarMetodoException("Não é possível registrar pagamento para um aluno não matriculado");
		}
		
		Pagamento pagamento = new Pagamento();
		pagamento.setTipo(Enum.valueOf(TipoDePagamento.class, tipoDePagamento));
		pagamento.setData(converteStringParaData(data));
		pagamento.setValor(new Long(valor));
		aluno.getPagamentos().add(pagamento);
	}

	@Override
	public void promoveAluno(String id) {
		Aluno aluno = getAluno(id);
		if (aluno.getEstagioAtual().getNumero() == 8){
			throw new ImpossivelExecutarMetodoException("Impossível promover aluno. Máximo de estágios alcançado.");
		}
		
		if (aluno.getEstagioAtual().getFaltas().size() >= (TOTAL_DE_AULAS_POR_ESTAGIO * PORCENTAGEM_PEMITIDA_DE_FALTAS / 100)){
			throw new ImpossivelExecutarMetodoException("Aluno possui muitas faltas. Não pode ser promovido.");
		}
		
		aluno.setEstagioAtual(aluno.getEstagios().get(aluno.getEstagioAtual().getNumero()));
		acessoADadosDeAluno.salva(aluno);
	}

	@Override
	public void agendaExame(String id, String data) {
		log.debug("Agendando exame");
		Aluno aluno = getAluno(id);
		Date dataObtida = converteStringParaData(data);
		log.debug("Data obtida: " + dataObtida);
		aluno.getEstagios().get(aluno.getEstagioAtual().getNumero() - 1).setDataDoExame(dataObtida);
		log.debug("Data do exame: " + aluno.getEstagioAtual().getDataDoExame());
		acessoADadosDeAluno.salva(aluno);
	}

	@Override
	public void insereNota(String id, long nota, String data) {
		Aluno aluno = getAluno(id);
		
		if(nota < 0.0 || nota > 10.0){
			throw new ImpossivelExecutarMetodoException("Nota deve ser um valor entre 0.0 e 10.0");
		}
		
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setNota(nota);
		avaliacao.setData(converteStringParaData(data));
		aluno.getEstagioAtual().getAvaliacoes().add(avaliacao);
		acessoADadosDeAluno.salva(aluno);
	}

	@Override
	public String emiteRelatorioFinanceiro(String id, String data, String atributo) {
		Aluno aluno = getAluno(id);
		ResumoFinanceiro resumo = new ResumoFinanceiro();
		
		Calendar dataDeMatricula = Calendar.getInstance();
		dataDeMatricula.setTime(aluno.getMatricula().getDataDeMatricula());
		
		Calendar dataDoRelatorio = Calendar.getInstance();
		dataDoRelatorio.setTime(converteStringParaData(data));
		
		int diasDecorridosParaAtraso = dataDoRelatorio.get(Calendar.DAY_OF_MONTH) - dataDeMatricula.get(Calendar.DAY_OF_MONTH);
		resumo.setValorDevido(VALOR_DA_MENSALIDADE / 30 * diasDecorridosParaAtraso);
		
		Iterator<Pagamento> it = aluno.getPagamentos().iterator();
		while (it.hasNext()) {
			Pagamento pagamento = it.next();
			if(pagamento.getData().compareTo(dataDoRelatorio.getTime()) <= 0){
				resumo.setValorPago(new Long(resumo.getValorPago() + pagamento.getValor()));
			}
		}
		
		return getAtributo(atributo, resumo);
	}

	@Override
	public String emiteHistoricoDePagamentos(String id, String dataDeInicio, String dataDeTermino, String posicao, String atributo) {
		Aluno aluno = getAluno(id);
		
		Date dataParaInicio = converteStringParaData(dataDeInicio);
		Date dataParaTermino = converteStringParaData(dataDeTermino);
		
		if (dataParaInicio.after(dataParaTermino)){
			throw new ImpossivelExecutarMetodoException("Data de Início deve ser menor ou igual à data de término");
		}
		
		
		List<Pagamento> pagamentos = new ArrayList<Pagamento>();
		for (Pagamento pagamento : aluno.getPagamentos()) {
			if(pagamento.getData().compareTo(dataParaTermino) <= 0 && pagamento.getData().compareTo(dataParaInicio) >= 0){
				pagamentos.add(pagamento);
			}
		}
		return getAtributo(atributo, pagamentos.get(new Integer(posicao)));
	}

	@Override
	public void registraFalta(String id, String data) {
		Aluno aluno = getAluno(id);
		
		if(!aluno.isMatriculado()){
			throw new ImpossivelExecutarMetodoException("Aluno não matriculado");
		}
		
		Falta falta = new Falta();
		falta.setData(converteStringParaData(data));
		aluno.getEstagioAtual().getFaltas().add(falta);
	} 
}
