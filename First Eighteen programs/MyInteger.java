package io.github.xieyezi;

public class MyInteger {
      private int value;
      MyInteger(int value) {
    	  this.value = value;
      }
	  public int getValue() {
		return value;
	  }
      public boolean isEven() {
    	  if(value%2 == 0)
    		  return true;
    	  else
    		  return false;
      }
      public boolean isOdd() {
    	  if(value%2 != 0)
    		  return true;
    	  else
    		  return false;
      }
      public boolean isPrime() { 
    	  boolean isPrime = true;
    	 for(int i = 2;i<value/2;i++) {
    		 if(value%i==0) {
    			 isPrime = false;
                  break;
    		 }
    		 else{
    			 isPrime = true;
    			 break;
    		 }
    	 }
    	 return isPrime;
      }
      public static boolean isEven(int value) {
    	  if(value%2 == 0)
    		  return true;
    	  else
    		  return false;
      }
      public static boolean isOdd(int value) {
    	  if(value%2 != 0)
    		  return true;
    	  else
    		  return false;
      }
      public static boolean isPrime(int value) { 
    	  boolean isPrime = true;
    	 for(int i = 2;i<value/2;i++) {
    		 if(value%i==0) {
    			 isPrime = false;
                  break;
    		 }
    		 else{
    			 isPrime = true;
    			 break;
    		 }
    	 }
    	 return isPrime;
      }
      public static boolean isEven(MyInteger num) {
    	  if(num.value%2 == 0)
    		  return true;
    	  else
    		  return false;
      }
      public static boolean isOdd(MyInteger num) {
    	  if(num.value%2 != 0)
    		  return true;
    	  else
    		  return false;
      }
      public static boolean isPrime(MyInteger num) { 
    	  boolean isPrime = true;
    	 for(int i = 2;i<num.value/2;i++) {
    		 if(num.value%i==0) {
    			 isPrime = false;
                  break;
    		 }
    		 else{
    			 isPrime = true;
    			 break;
    		 }
    	 }
    	 return isPrime;
      }
      public boolean equals(int num) {
    	return   this.value == num;
      }
      public boolean equals(MyInteger num) {
      	return   this.value == num.value;
        }
      public static int parseInt(char [] arr) {
    	  int result = 0;
    	  for(char anChar: arr) {
    		  result *=10;
    		  result += (anChar-'0');
    	  }
    	  return result;
      }
      public static int parseInt(String s) {
    	  int result = 0;
    	  for(int i = 0;i<s.length();i++) {
    		  result *=10;
    		  result += s.charAt(i)-'0';
    	  }
    	  return result;
      }
      public static void main(String[] args) {
    	  MyInteger integer1 = new MyInteger((int) (Math.random()*101));
    	  MyInteger integer2 = new MyInteger((int) (Math.random()*101));
    	  System.out.println(integer1.getValue());
    	  System.out.println(integer1.isEven());
    	  System.out.println(integer1.isOdd());
    	  System.out.println(integer1.isPrime());
    	  System.out.println(isEven(integer1.value));
    	  System.out.println(isOdd(integer1.value));
    	  System.out.println(isPrime(integer1.value));
    	  System.out.println(MyInteger.isEven(integer1));
    	  System.out.println(MyInteger.isOdd(integer1));
    	  System.out.println(MyInteger.isPrime(integer1));
    	  int b = 10;
    	  System.out.println(integer1.equals(b));
    	  System.out.println(integer1.equals(integer2));
    	  char arr[] = {'a','b','c'};
    	  System.out.println(MyInteger.parseInt(arr));
    	  String s = "zhangxiaojun";
    	  System.out.println(MyInteger.parseInt(s));
	}
}



























