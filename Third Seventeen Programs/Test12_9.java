package io.xieyezi.github;

import java.util.Scanner;

public class Test12_9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个二进制的字符串！：");
		String str = input.nextLine();
		try {
			System.out.println(bin2Dec(str));
		} catch (BianryFormatException ex) {
			System.out.println(ex);
		} finally {
			input.close();
		}
	}

	public static int bin2Dec(String binaryString) throws BianryFormatException {
		int num = 0;
		for (int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) != '1' && binaryString.charAt(i) != '0') {
				throw new BianryFormatException(binaryString);
			}
		}
		for (int j = 0; j < binaryString.length(); j++) {
			if (binaryString.charAt(j) == '1') {
				num += Math.pow(2, (binaryString.length() - j));
			}
		}
		return num;
	}
}

	class BianryFormatException extends Exception {
	   public BianryFormatException(String s){
		   super(s+" this string is not a binary string!");
	   }
   }
