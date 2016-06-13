package io.github.xieyezi;
import java.util.Scanner;

public class ATM {
	Scanner input = new Scanner(System.in);
	public void Enterid(Account arr[]) {
		while (true) {
			System.out.println("Enter an id:");
			int id = input.nextInt();
			if (id < 0 || id > 9)
				continue;
			else
				Menu(arr[id]);
		}
	}
	public void Menu(Account account) {
		while (true) {
			System.out.println("Main menu:");
			System.out.println("1: check balance");
			System.out.println("2: withdraw");
			System.out.println("3: deposit");
			System.out.println("4: exit");
			int num = input.nextInt();
			switch (num) {
			case 1:
				System.out.println(account.getBalance());
				break;
			case 2:
				account.withDraw();
				break;
			case 3:
				account.deposit();
				break;
			case 4:
				   return;
			default:
				break;
			}
		}
	}
	public static void main(String[] args) {
		Account arr[] = new Account[10];
		ATM a = new ATM();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Account();
			arr[i].setId(i);
			arr[i].setBalance(100);
		}
		a.Enterid(arr);
	}
}
