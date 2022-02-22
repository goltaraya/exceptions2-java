package model.entities;

import model.exceptions.EmptyBalanceException;
import model.exceptions.WithdrawBiggerBalanceException;
import model.exceptions.WithdrawLimitException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	// Constructors 
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	// Getters and Setters
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	// Functions
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw (Double amount) {
		if(balance == 0) {
			throw new EmptyBalanceException("The current balance is empty.");
		}
		
		if(amount > balance) {
			throw new WithdrawLimitException("The amount is bigger than the current balance.");
		}
		
		if(amount > withdrawLimit) {
			throw new WithdrawBiggerBalanceException("The amount is bigger than the withdraw limit.");
		}
		
		balance -= amount;
	}
}
