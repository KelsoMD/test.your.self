package by.nesterenok.testyourself.web.util;

public class ValidateNullParamException extends RuntimeException{

	private static final long serialVersionUID = 5663536041889774852L;

	public ValidateNullParamException() {
		super();
	}

	
	public ValidateNullParamException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateNullParamException(String message) {
		super(message);
	}

	public ValidateNullParamException(Throwable cause) {
		super(cause);
	}
	
	

}
