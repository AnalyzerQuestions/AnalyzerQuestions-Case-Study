package br.edu.ifpb.ws.analyzerQuestionsRESTful.exception;

public class UniqueConstraintException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UniqueConstraintException(String message) {

		super(message);
	}

}
