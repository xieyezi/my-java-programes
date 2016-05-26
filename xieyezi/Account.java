package io.github.xieyezi;

import java.util.Date;

import java.util.Scanner;

public class Account {
    private int id = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    Date dateCreated = new Date();
    Scanner input = new Scanner(System.in);
    Account() {
    	this.id = 0;  	
    }
    Account(int id,double balance){
    	this.id = id;
    	this.balance = balance;
    }
    public int getId(){   //id的访问器//
    	return id;
    }
    public double getBalance() {    //balance的访问器/
    	return balance;
    }
    public double getannualInterestRate() {    //annualInterestRate的访问器/
    	return annualInterestRate;
    }
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getMonthlyInterest() {
    	double monthlyInterest;
    	monthlyInterest = balance*annualInterestRate/1200.0;
    	return monthlyInterest;
    }
    public void withDraw() {
        double money;
        System.out.println("你想取多少钱呢?");
    	money = input.nextDouble();
    	this.balance=balance-money;
    }
    public void deposit() {
    	double money;
    	System.out.println("你存取多少钱呢?");
    	money = input.nextDouble();
    	this.balance=balance+money;
    }
    public static void main(String[] args) {
		Account account = new Account(1122,20000);
		account.annualInterestRate=4.5;
		System.out.println(account.balance);
		System.out.println(account.getMonthlyInterest());
		System.out.println(account.dateCreated);
	}
}