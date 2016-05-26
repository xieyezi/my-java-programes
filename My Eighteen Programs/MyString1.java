package io.github.xieyezi;

public class MyString1 {
	public static void main(String[] args) {
		String a = "adhvb";
		char[] s = { 'a', 'b', 'c' };
		MyString1 d = new MyString1(a);
		System.out.println("将AGdFa 转成小写的字母"+d.toLowerCase().c);
		MyString1 str = new MyString1(s);
		d.charAt(1);
		str.charAt(2);
		System.out.print("输出字符数组的第3个字符 "+str.charAt(2) + " " + "输出字符串的第二个字符 "+d.charAt(1));
		MyString1 f=new MyString1();
		System.out.println("输出从下标0到下标2的字符串 ："+a.substring(0,2));
		System.out.print("字符长度  "+f.length1());
     
	}

	public String c = "AGdFa";
	public MyString1(String c) {
		this.c = c;
	}
	public MyString1()
	{
		
	}
	public MyString1(char[] chars) {
		for (int i = 0; i < chars.length; i++)
			c += chars[i];

	}

	public char charAt(int a) {
		char ch = c.charAt(a);
		return ch;
	}

	public int length1() {
		int a=c.length();
		return a;
	}

	String getC() {
		return c;
	}

	public MyString1 substring(int begin, int end) {
		String s = "";
		
		char ch;
		int a = begin ;
		int b = end;
		for (; a < b ; a++) {
			ch = c.charAt(a);
			s += ch;
		}
		
		MyString1 d = new MyString1(s);
		return d;

	}

	public MyString1 toLowerCase() {
		String str = c;
		String str1 = "";
		char ch1;
		int a = str.length();
		for (int i = 0; i < a; i++) {
			char ch = str.charAt(i);
			if (ch < 'a') {
				ch1 = (char)(ch +32);
				str1 += ch1;
			} else
				str1 += ch;
		}
		MyString1 c = new MyString1(str1);
		return c;

	}

	

	public boolean equals(MyString1 s) {

		if (c == s.getC())
			return true;
		else
			return false;
	}

	public static MyString1 ValueOf(int i) {
		String s = "";
		s += i;
		MyString1 c = new MyString1(s);
		return c;

	}
}