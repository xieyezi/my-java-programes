package io.github.xieyezi;

import java.util.Date;

public class Test9_3 {
	public static void main(String[] args) {
		Date date[] = new Date[8];
		long time = 10000;
		for (int i = 0; i < 8; i++) {
			date[i] = new Date(time);
			System.out.println(time + "---" + date[i].toString());
			time=time*10;
		}
	}
}
