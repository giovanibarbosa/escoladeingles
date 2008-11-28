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
}