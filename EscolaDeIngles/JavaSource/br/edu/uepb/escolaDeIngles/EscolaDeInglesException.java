package br.edu.uepb.escolaDeIngles;

/**
 * Exce��o base para o sistema Escola de Ingl�s
 *
 */
public class EscolaDeInglesException extends RuntimeException {

	private static final long serialVersionUID = -1964473664509724140L;

	public EscolaDeInglesException() {
		super();
	}

	public EscolaDeInglesException(String message) {
		super(message);
	}

	public EscolaDeInglesException(Throwable cause) {
		super(cause);
	}

	public EscolaDeInglesException(String message, Throwable cause) {
		super(message, cause);
	}

}
