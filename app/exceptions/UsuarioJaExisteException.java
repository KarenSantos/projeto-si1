package exceptions;

public class UsuarioJaExisteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public UsuarioJaExisteException(String message){
		super(message);
	}
}
