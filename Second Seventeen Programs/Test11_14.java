package io.github.xieyezi;

import java.util.ArrayList;
import java.util.Scanner;

public class Test11_14 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		Scanner input =new Scanner(System.in);
		System.out.println("Enter five integer for list1£º");
		for(int i = 0;i<5;i++){
			list1.add(input.nextInt());
		}
		System.out.println("Enter five integer for list2£º");
		for(int i = 0;i<5;i++){
			list2.add(input.nextInt());
		}
		input.close();
		list = union(list1,list2);
		for (int i : list) {
			System.out.printf("%d ",i);
		}
	}
     public static ArrayList<Integer> union(ArrayList<Integer> list1,ArrayList<Integer> list2){
    	 for(int i=0;i<list2.size();i++){
    		 list1.add(list2.get(i));
    	 }
    	 return list1;
     }
}
