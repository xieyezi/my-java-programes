package io.github.xieyezi;

import java.util.ArrayList;

public class Test11_7 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(10);
		list.add(25);
		list.add(33);
		list.add(48);
		Test11_7.shuffle(list);
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}

	public static void shuffle(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int m = (int) (Math.random() * (list.size()));
			int n = (int) (Math.random() * (list.size()));
			Integer temp = list.get(m);
			list.set(m, list.get(n));
			list.set(n, temp);
		}
	}
}
