package io.xieyezi.github;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Test12_25 {
	public static void main(String[] args) throws IOException{
		Scanner input= null;
		try {
			URL rul = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
			 input = new Scanner(rul.openStream());
			 int assistant = 0;
			 int full = 0;
			 int associate = 0;
			 
		}
		catch (MalformedURLException ex) {
			ex.printStackTrace();
		}
	}
}
