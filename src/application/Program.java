package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.EmptyBalanceException;
import model.exceptions.WithdrawBiggerBalanceException;
import model.exceptions.WithdrawLimitException;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();

			Account acc = new Account(number, holder, balance, withdrawLimit);
			System.out.print("\nEnter amount for withdraw: ");
			double amount = sc.nextDouble();
			acc.withdraw(amount);

			System.out.println("New balance: $ " + String.format("%.2f", acc.getBalance()));

		} catch (EmptyBalanceException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (WithdrawLimitException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (WithdrawBiggerBalanceException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		} finally {
			sc.close();
		}
	}
}
