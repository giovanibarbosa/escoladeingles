package br.edu.uepb.escolaDeIngles.acessoADados;

import br.edu.uepb.escolaDeIngles.EscolaDeInglesException;

public class EntradaESaidaException extends EscolaDeInglesException {

	private static final long serialVersionUID = -4683626311326582285L;

	public EntradaESaidaException() {
		super();
	}

	public EntradaESaidaException(String message) {
		super(message);
	}

	public EntradaESaidaException(Throwable cause) {
		super(cause);
	}

	public EntradaESaidaException(String message, Throwable cause) {
		super(message, cause);
	}

}
