package io.github.xieyezi;

import java.util.ArrayList;
import java.util.Scanner;

public class Mystack extends ArrayList<Object>{
      public Mystack(){
    	  
      }
      public boolean isEmpty(){
    	  return super.isEmpty();
      }
      public int getSize(){
    	  return super.size();
      }
      public Object peek(){
    	  return super.get(getSize()-1);
      }
      public Object pop(){
    	  Object o = super.get(getSize()-1);
    	  super.remove(getSize()-1);
    	  return o;
      }
      public void push(Object o){
    	  super.add(o);
      }
      @Override
      public String toString(){
    	  return "stack:"+super.toString();
      }
      public static void main(String[] args) {
    	  String s1 = new String();
    	  String s2 = new String();
    	  String s3 = new String();
    	  String s4 = new String();
    	  String s5 = new String();
    	  Mystack stack = new Mystack();
    	  Scanner input = new Scanner(System.in);
		 System.out.println("ÇëÊäÈëÎå¸ö×Ö·û´®£º");
		 s1 = input.nextLine();
		 s2 = input.nextLine();
		 s3 = input.nextLine();
		 s4 = input.nextLine();
		 s5 = input.nextLine();
		 input.close();
		 stack.add(s1);
		 stack.add(s2);
		 stack.add(s3);
		 stack.add(s4);
		 stack.add(s5);
		 for(int i = stack.size()-1;i>=0;i--){
			 System.out.println(stack.get(i));
		 }
	}
}
