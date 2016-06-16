package io.xieyezi.github;

import java.util.Scanner;

public class Test12_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个二进制的字符串！：");
		String str = input.nextLine();
		try {
			System.out.println(bin2Dec(str));
		} catch (NumberFormatException ex) {
			System.out.println(ex);
		} finally {
			input.close();
		}
	}

	public static int bin2Dec(String binaryString)throws NumberFormatException {
	   int num = 0;
	   for(int i = 0;i<binaryString.length();i++){
		   if(binaryString.charAt(i)!='1' && binaryString.charAt(i)!='0'){
			  throw new NumberFormatException("this string is not a binary string!");
		   }
	   }
	     for(int j = 0;j<binaryString.length();j++){
				   if(binaryString.charAt(j)=='1'){
				   num += Math.pow(2, (binaryString.length()-j));
				   }
	   }
	   return num;
   }
}
