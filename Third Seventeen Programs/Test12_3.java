package io.xieyezi.github;

import java.util.Scanner;

public class Test12_3 {
   public static void main(String[] args) {
	 Scanner input = null;
	int arr[] = new int[100];
	for(int i = 0;i<arr.length;i++){
		arr[i]  =(int) (Math.random()*101);
	}
	
	try{
		System.out.println("请输入一个下标：");
		input = new Scanner(System.in);
		int index = input.nextInt();
		System.out.println("arr["+index+"]"+"="+arr[index]);
	}
	catch(ArrayIndexOutOfBoundsException ex){
		System.out.println("Out of Bounds");
	}
	finally{
		input.close();
	}
}
}
