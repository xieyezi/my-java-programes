package io.xieyezi.github;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Test12_19 {
	public static void main(String[] args) throws IOException {
		Scanner input= null;
		try {
			URL rul = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
			 input = new Scanner(rul.openStream());
			int num = 0;
			boolean isWhiteSpace = true;
			while (input.hasNext()) {
				String s = input.nextLine();
				for (int i =0; i < s.length(); i++) {
					char c = s.charAt(i);
					if (c == ' ' || c == '\t' || c == '\n')
						isWhiteSpace = true;
					else if (isWhiteSpace) {
						num++;
						isWhiteSpace = false;
					}
				}
			}
			System.out.println(num);
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}
		finally{
			input.close();
		}
	}
}
