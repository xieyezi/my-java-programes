package io.github.xieyezi;

import java.util.GregorianCalendar;

public class Test9_5 {
     public static void main(String[] args) {
		GregorianCalendar a = new GregorianCalendar();
		System.out.println(a.get(GregorianCalendar.YEAR)+"---"+(a.get(GregorianCalendar.MONTH)+1)+"---"+a.get(GregorianCalendar.DAY_OF_MONTH));
		a.setTimeInMillis(123456789L);
		System.out.println(a.get(GregorianCalendar.YEAR)+"---"+(a.get(GregorianCalendar.MONTH)+1)+"---"+a.get(GregorianCalendar.DAY_OF_MONTH));
	}
}