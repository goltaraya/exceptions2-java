package model.exceptions;

public class EmptyBalanceException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EmptyBalanceException(String msg) {
		super(msg);
	}
}
