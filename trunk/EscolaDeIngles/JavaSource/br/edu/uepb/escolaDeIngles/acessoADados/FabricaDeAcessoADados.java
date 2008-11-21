/**
 * 
 */
package br.edu.uepb.escolaDeIngles.acessoADados;

import java.io.IOException;

/**
 * 
 * Fábrica para acesso a Dados
 */
public class FabricaDeAcessoADados {

	// Singleton
	private static FabricaDeAcessoADados instancia = new FabricaDeAcessoADados();

	private FabricaDeAcessoADados() {}
	
	public static FabricaDeAcessoADados GetInstance(){
		return instancia;
	}

	public AcessoADadosDeAluno criaAlunoDao() throws IOException {
		return new AcessoADadosXmlDeAluno();
	}

}
