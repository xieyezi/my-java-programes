package io.github.xieyezi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Account1 {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	private String name;
	private ArrayList<Transactions> transations = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	public Account1() {

	}

	public Account1(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public Account1(String name, int id, double balance) {
		this.name = name;
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public double getMonthlyInterest() {
		double monthlyInterest;
		monthlyInterest = balance * annualInterestRate / 1200.0;
		return monthlyInterest;
	}

	public void withDraw() {
		 System.out.println("请输入取款金额：");
		    double money = input.nextDouble();
		    this.balance=balance-money;
			this.transations.add(new Transactions('W', this.balance, "withDraw"));
		}

	public void deposit() {
		    System.out.println("请输入存款金额：");
		    double money = input.nextDouble();
		    this.balance=balance+money;
			this.transations.add(new Transactions('D', this.balance, "deposit"));
		}
	@Override
	public String toString() {
		return "姓名：" + this.name + "\n" + "月利率：" + this.getAnnualInterestRate() + "\n" + "余额：" + this.balance +"\n";
			
	}

	public static void main(String[] args) {
		Account1 account = new Account1("George", 1122, 1000);
		account.annualInterestRate = 1.5;
		for(int i = 1;i<=3;i++){
			account.deposit();
		}
		for(int j = 1;j<=3;j++){
			account.withDraw();
		}
		System.out.println(account.toString());
		for(int i=0;i<account.transations.size();i++)
		{
			System.out.println(account.transations.get(i).toString());
		}
	}
}

class Transactions {
	private double amount;
	private double balance;
	private String description;
	private Date date = new Date();
	private char type;
	Scanner input = new Scanner(System.in);

	public Transactions(char type, double balance, String description) {
		this.type = type;
		this.balance = balance;
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}

	public char getType() {
		return type;
	}
	@Override
	public String toString()
	{
		return "交易日期："+date+" 交易类型："+type+" 交易量："+amount+" 余额："+balance+" 交易描述："+description;
	}
}
