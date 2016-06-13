package io.github.xieyezi;

import java.util.Date;
import java.util.Scanner;

class Account {
	protected String id = "0000";
	protected double balance = 0.0;
	protected double annualInterestRate = 0.0;
	Date dateCreated = new Date();
	Scanner input = new Scanner(System.in);

	Account() {
		this.id = "0000";
	}

	Account(String id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public double getannualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMonthlyInterest() {
		double monthlyInterest;
		monthlyInterest = balance * annualInterestRate / 1200.0;
		return monthlyInterest;
	}

	public void withDraw() {
		double money;
		System.out.println("������ȡ����:");
		money = input.nextDouble();
		this.balance = balance - money;
	}

	public void deposit() {
		double money;
		System.out.println("����������:");
		money = input.nextDouble();
		this.balance = balance + money;
	}
}

class checkingAccount extends Account {
	public checkingAccount() {
		super();
	}

	public checkingAccount(String id, double balance) {
		super(id, balance);
	}

	@Override
	public void withDraw() {
		double money;
		System.out.println("������ȡ����:");
		money = input.nextDouble();
		if (balance - money < -1000) { // �趨͸֧���Ϊ1000
			System.out.println("���û���͸֧!");
		} else {
			this.balance = balance - money;
		}
	}

	@Override
	public String toString() {
		return "�˺�:" +this.id +"\n"+ "��������:" + this.dateCreated +"\n"+ "���:" + this.getBalance();
	}
}

class saveingAccount extends Account {
	public saveingAccount() {
		super();
	}

	public saveingAccount(String id, double balance) {
		super(id, balance);
	}

	@Override
	public void withDraw() {
		double money;
		System.out.println("������ȡ����:");
		money = input.nextDouble();
		if (balance - money < 0) {
			System.out.println("���û�����!");
		} else {
			this.balance = balance - money;
		}
	}

	@Override
	public String toString() {
		return "�˺�:" +this.id +"\n"+ "��������:" + this.dateCreated +"\n"+ "���:" + this.getBalance();
	}
}
public class Test11_3{
	public static void main(String[] args) {
		checkingAccount check = new checkingAccount("0001", 5000);
		check.annualInterestRate = 4.5;
		saveingAccount save = new saveingAccount("0002", 8000);
		save.annualInterestRate = 5.5;
		check.withDraw();
		System.out.println();
		System.out.println(check.toString());
		save.withDraw();
		System.out.println();
		System.out.println(save.toString());
	}
}