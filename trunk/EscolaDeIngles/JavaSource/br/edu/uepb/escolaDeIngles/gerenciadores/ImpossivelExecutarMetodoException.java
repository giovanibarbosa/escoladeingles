package br.edu.uepb.escolaDeIngles.gerenciadores;

import br.edu.uepb.escolaDeIngles.EscolaDeInglesException;

/**
 * Exceção lançada quando não é possível executar um método do Gerenciador de
 * Aluno, seja por regra de negócio, seja por falha na execução.
 * 
 */
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
