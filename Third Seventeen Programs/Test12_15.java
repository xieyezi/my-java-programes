package io.xieyezi.github;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test12_15 {
    public static void main(String[] args)throws IOException {
	File file = new File("Test12_15.txt");
	if(!file.exists()){
		file.createNewFile();
	}
	PrintWriter output = new PrintWriter(file);
	for(int i= 1;i<=100 ;i++){
		 output.write((int )(Math.random()*1000)+" ");
	}
	output.close();
	Scanner input1 = new Scanner(file);
	String str = input1.nextLine();
	int arr[] = new int[100];
	Scanner input2 = new Scanner(str);
	for(int i = 0;i<100;i++){
		arr[i]=input2.nextInt();
	}
	Arrays.sort(arr);
	for (int i : arr) {
		System.out.println(i);
	}
	input1.close();
	input2.close();
   }
}
