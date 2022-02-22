package model.exceptions;

public class WithdrawBiggerBalanceException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public WithdrawBiggerBalanceException(String msg) {
		super(msg);
	}
}
