package br.com.proposta.api.controllers.exceptions;

public class SolicitacaoNaoEncontradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SolicitacaoNaoEncontradaException(Long id) {
		super("Solicitação não econtrada, id: " + id);
	}

}
