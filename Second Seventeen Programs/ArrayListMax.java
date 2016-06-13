package io.github.xieyezi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListMax {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (i != 0) {
			list.add(i);
			i = input.nextInt();                                                                                                                                                
		}
		System.out.println("最大数为:"+max(list));
		input.close();
	}

	public static Integer max(ArrayList<Integer> list) {
		if (list.size() == 0 || list == null)
			return null;
		else
			return Collections.max(list);
	}
}