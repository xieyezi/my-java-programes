package io.xieyezi.github;

import java.io.File;
import java.util.Scanner;

public class Test12_13 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage:java Test12_13 filename");
			System.exit(0);
		}
		File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println("Source file " + args[1] + "do not exist!");
			System.exit(0);
		}

		try {
			int characters = 0, words = 0, lines = 0;
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String s = input.nextLine();
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == ' ') {
						words++;
					}
					characters++;
				}
				lines++;
			}
			input.close();
			System.out.println(characters + " characters");
			System.out.println(words + " words");
			System.out.println(lines + " lines");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
