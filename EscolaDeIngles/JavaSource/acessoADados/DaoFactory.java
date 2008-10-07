/**
 * 
 */
package acessoADados;

import java.io.IOException;

/**
 * 
 * Fábrica para acesso a Dados
 */
public class DaoFactory {

	// Singleton
	private static DaoFactory instancia = new DaoFactory();

	private DaoFactory() {
	}
	
	public static DaoFactory GetInstance(){
		return instancia;
	}

	public AlunoDao criaAlunoDao() throws IOException {
		return new AlunoDaoXml();
	}

}
