package cruise.exception;

public class GeneratorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GeneratorException(String strMessage) {
		super(strMessage);
	}
	public GeneratorException(String strMessage, Exception e) {
		super(strMessage, e);
	}
}
