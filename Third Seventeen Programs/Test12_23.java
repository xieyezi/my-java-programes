package io.xieyezi.github;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Test12_23 {
	public static void main(String[] args) throws IOException {
		Scanner input = null;
		try {
			URL rul = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
			input = new Scanner(rul.openStream());
			int time = 0;
			double sum = 0.0;
			while(input.hasNext()){
					time++;
					sum+=input.nextDouble();
			}
			System.out.println("sum:"+sum);
			System.out.println("average:"+sum/time);
			input.close();
		}

		catch (MalformedURLException ex) {
			ex.printStackTrace();
		}

	}
}
