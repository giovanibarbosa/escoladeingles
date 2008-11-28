/**
 * 
 */
package br.edu.uepb.escolaDeIngles;

import br.edu.uepb.escolaDeIngles.acessoADados.AcessoADadosDeAluno;
import br.edu.uepb.escolaDeIngles.acessoADados.AcessoADadosXmlDeAluno;
import br.edu.uepb.escolaDeIngles.gerenciadores.GerenciadorDeAluno;
import br.edu.uepb.escolaDeIngles.gerenciadores.GerenciadorDeAlunoImpl;

/**
 * 
 * Fábrica para acesso a Dados
 */
public class FabricaDeObjetos {

	// Singleton
	private static FabricaDeObjetos instancia = new FabricaDeObjetos();

	private AcessoADadosDeAluno acessoADadosDeAluno;
	
	private GerenciadorDeAlunoImpl gerenciadorDeAluno;
	
	private FabricaDeObjetos() {
		acessoADadosDeAluno =  new AcessoADadosXmlDeAluno();
		
		gerenciadorDeAluno = new GerenciadorDeAlunoImpl();
		gerenciadorDeAluno.setAcessoADadosDeAluno(acessoADadosDeAluno);
	}
	
	public static FabricaDeObjetos GetInstance(){
		return instancia;
	}

	public AcessoADadosDeAluno criaAcessoADadosDeAluno() {
		return acessoADadosDeAluno;
	}
	
	public GerenciadorDeAluno criaGerenciadorDeAluno(){
		return gerenciadorDeAluno;
	}

}
