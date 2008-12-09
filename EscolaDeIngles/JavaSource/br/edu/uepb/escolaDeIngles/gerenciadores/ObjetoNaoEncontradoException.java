package br.edu.uepb.escolaDeIngles.gerenciadores;

import br.edu.uepb.escolaDeIngles.EscolaDeInglesException;

/**
 * Exce��o lan�ada quando n�o � poss�vel encontrar um objeto em uma opera��o de consulta
 *
 */
public class ObjetoNaoEncontradoException extends EscolaDeInglesException {

	private static final long serialVersionUID = 1889513045986681404L;

	public ObjetoNaoEncontradoException() {
		super();
	}

	public ObjetoNaoEncontradoException(String arg0) {
		super(arg0);
	}

	public ObjetoNaoEncontradoException(Throwable arg0) {
		super(arg0);
	}

	public ObjetoNaoEncontradoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
