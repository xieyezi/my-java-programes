package io.github.xieyezi;

import java.util.Arrays;

public class MyString1 { 
	public char value[] ;
	public MyString1()
	{	
	}
	public MyString1(String str) {
		this.value = str.toCharArray();
	}
	public MyString1(char[] chars) {
		this.value = chars;
	}
	String getStr() {
		return this.value.toString();
	}
	public char charAt(int a) {
		return (char)(a+'0');
	}
	public int length() {      
        return this.value.length;
	}
	public MyString1 substring(int begin, int end) {			
		return new MyString1(Arrays.copyOfRange(this.value, begin, end));
	}
	public MyString1 toLowerCase() {
		char[] Arr2 = new char[value.length];
		for(int i = 0;i<this.value.length;i++){
			Arr2[i] = Character.toLowerCase(value[i]);
		}
		return new MyString1(Arr2);
	}
	public boolean equals(MyString1 s) {
		int n = s.value.length;
		if(s.value.length == this.value.length){
			 int i = 0;
             while (n-- != 0) {
                 if (this.value[i] != s.value[i])
                     return false;
                 i++;
             }
             return true;
         }
		return false;
	}
	
	public static MyString1 ValueOf(int i) {
		return new MyString1(Integer.toString(i));
	}
	public static void main(String[] args) {
		char[] arr = {'A','b','c','d'};
		MyString1 s = new MyString1(arr);
		System.out.println(s.value);
		System.out.println(s.length());
		MyString1 s1 = s.substring(0, 2);
		System.out.println(s1.value);
		System.out.println(s.toLowerCase());
		System.out.println(MyString1.ValueOf(34));
	}
}