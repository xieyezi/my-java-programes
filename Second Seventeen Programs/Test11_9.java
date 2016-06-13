package io.github.xieyezi;

import java.util.ArrayList;
import java.util.Scanner;

public class Test11_9 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the array size n:");
		int n = input.nextInt();
		input.close();
		int arr[][] = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int) (Math.random() * 2);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			int num = 0;
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%d  ", arr[i][j]);
			}
			if (num % n == 0)
				System.out.println();
		}
		System.out.println();
		list1 = rawMax(arr);
		list2 = colMax(arr);
		System.out.printf("The largest row index:");
		for (int i:list1)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.print("The largest col index:");
		for (int i:list2)
		{
			System.out.print(i+" ");
		}
	}

	public static ArrayList<Integer> rawMax(int arr[][]) {
		ArrayList<Integer> list = new ArrayList<>();
		int rawmax = 0;
		int a[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = 0;
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1)
					a[i]++;
			}
			if (a[i] > rawmax)
				rawmax = a[i];
		}
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==rawmax)
				list.add(i);
		}
		return list;
	}

	public static ArrayList<Integer> colMax(int arr[][]) {
		ArrayList<Integer> list = new ArrayList<>();
		int colmax = 0;
		int a[] = new int[arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = 0;
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[j][i] == 1)
					a[i]++;
			}
			if (a[i] > colmax)
				colmax = a[i];
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == colmax)
				list.add(i);
		}
		return list;
	}
}
