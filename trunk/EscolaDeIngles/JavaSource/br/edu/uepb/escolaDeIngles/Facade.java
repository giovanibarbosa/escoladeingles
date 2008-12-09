package br.edu.uepb.escolaDeIngles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.uepb.escolaDeIngles.gerenciadores.GerenciadorDeAluno;

public class Facade {

	private static Log log = LogFactory.getLog(Facade.class);

	private static FabricaDeObjetos fabricaDeObjetos = FabricaDeObjetos.GetInstance();
	private static GerenciadorDeAluno gerenciadorDeAluno = fabricaDeObjetos.criaGerenciadorDeAluno();

	public void zeraSistema() {
		gerenciadorDeAluno.zeraSistema();
	}

	public String criaAluno(String nome, String endereco, String telefone) {
		log.info("Criando Aluno");
		return gerenciadorDeAluno.criaAluno(nome, endereco, telefone);
	}

	public void removeAluno(String id) {
		log.info("Removendo aluno");
		gerenciadorDeAluno.removeAluno(id);
	}

	public void modificaAluno(String id, String atributo, String valor) {
		log.info("Modificando aluno");
		gerenciadorDeAluno.modificaAluno(id, atributo, valor);
	}

	public String getAtributoDoAluno(String id, String atributo) {
		log.info("Recuperando Atributo do aluno");
		return gerenciadorDeAluno.getAtributoDoAluno(id, atributo);
	}
	
	public void matriculaAluno(String id, String data){
		log.info("Matricula aluno");
		gerenciadorDeAluno.matriculaAluno(id, data);
	}
	
	public void encerraMatricula(String id, String data){
		log.info("Encerra matrícula");
		gerenciadorDeAluno.encerraMatricula(id, data);
	}
	
	public void inserePagamento(String id, String tipoDePagamento, String data, String valor){
		log.info("Registra pagamento");
		gerenciadorDeAluno.inserePagamento(id, tipoDePagamento, data, valor);
	}
	
	public void promoveAluno(String id){
		log.info("Promove aluno");
		gerenciadorDeAluno.promoveAluno(id);
	}
	
	public void agendaExame(String id, String data){
		log.info("Agenda exame");
		gerenciadorDeAluno.agendaExame(id, data);
	}
	
	public void insereNota(String id, long nota, String data){
		log.info("Insere nota");
		gerenciadorDeAluno.insereNota(id, nota, data);
	}
	
	public String emiteRelatorioFinanceiro (String id, String data, String atributo){
		log.info("Emite relatório financeiro");
		return gerenciadorDeAluno.emiteRelatorioFinanceiro(id, data, atributo);
	}
	
	public String emiteHistoricoDePagamentos(String id, String dataDeInicio, String dataDeTermino, String posicao, String atributo){
		log.info("Emite histórico");
		return gerenciadorDeAluno.emiteHistoricoDePagamentos(id, dataDeInicio, dataDeTermino, posicao, atributo);
	}
	
	public void registraFalta(String id, String data){
		log.info("Registra falta");
		gerenciadorDeAluno.registraFalta(id, data);
	}
}