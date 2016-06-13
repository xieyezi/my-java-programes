package io.github.xieyezi;

import java.util.ArrayList;
import java.util.Scanner;

public class Test11_16 {
	public static void main(String[] args) {
		int num1 = (int) (Math.random() * 10);
		int num2 = (int) (Math.random() * 10);
		ArrayList<Integer> list = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.print("what is " + num1 + "+" + num2 + "?");
		int answer = input.nextInt();
		list.add(answer);
		while ((num1 + num2) != list.get(list.size() - 1)) {
			System.out.println("Wrong answer. Try again. what is " + num1 + "+" + num2 + "?");
			answer = input.nextInt();
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i) == answer) {
					System.out.println("you already entered " + answer);
					break;
				}
			}

			list.add(answer);
		}
		input.close();
		System.out.println("You got it!");
	}
}
