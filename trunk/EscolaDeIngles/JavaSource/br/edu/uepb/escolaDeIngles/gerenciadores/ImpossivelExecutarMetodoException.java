package br.edu.uepb.escolaDeIngles.gerenciadores;

import br.edu.uepb.escolaDeIngles.EscolaDeInglesException;

public class ImpossivelExecutarMetodoException extends EscolaDeInglesException {

	private static final long serialVersionUID = 166201085969615471L;

	public ImpossivelExecutarMetodoException() {
		super();
	}

	public ImpossivelExecutarMetodoException(String message) {
		super(message);
	}

	public ImpossivelExecutarMetodoException(Throwable cause) {
		super(cause);
	}

	public ImpossivelExecutarMetodoException(String message, Throwable cause) {
		super(message, cause);
	}
}
