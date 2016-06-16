package io.xieyezi.github;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test12_11 {
     public static void main(String[] args)throws Exception {
		if(args.length != 2){
			System.out.println("Usage:java Test12_11 Str filename");
			System.exit(0);
		}
		File file1 = new File(args[1]);
		if(!file1.exists()){
			System.out.println("Source file "+args[1]+" do not exist!");
			System.exit(1);
		}
		Scanner input = new Scanner(file1);
		StringBuilder str2 = new StringBuilder();
		while(input.hasNextLine()){
			String str1  = input.nextLine();
			str2.append(str1.replaceAll(args[0], "")+"\r\n");
		}
		input.close();
		PrintWriter output = new PrintWriter(file1);
		output.write(str2.toString());
		output.close();
	}
}
