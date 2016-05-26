package io.github.xieyezi;

public class StackofIntegers {
       private int [] elements;
       public int size;
       public static final int NUM = 16;
       public StackofIntegers() {
    	   this (NUM);
       }
       public StackofIntegers(int capacity) {
    	   elements = new int[capacity];
       }
       public void push(int value) {
    	   if(size >= elements.length) {
    		   int[] temp = new int[elements.length*2];
    		   System.arraycopy(elements, 0, temp, 0, elements.length);
    		   elements = temp;
    	   }
    	   elements[size++] = value;
       }
       public int pop() {
    	   return elements[--size];
       }
       public int peek() {
    	   return elements[size-1];
       }
       public boolean empty() {
    	   return size == 0;
       }
       public int getSize() {
    	   return size;
       }
       public static void main(String[] args) {
    	   StackofIntegers stack = new StackofIntegers();
    	   for(int i =1;i<=120;i++) {
    		   if(stack.Prime(i)){
    			   stack.push(i);
    		   }
    	   }
    	   while (!stack.empty())
    		   System.out.println(stack.pop() + " ");
    	   
	   }
       public boolean Prime(int num) { 
     	 boolean Prime = true;
     	 for(int i = 2;i<num/2;i++) {
     		 if(num%i==0) {
     			 Prime = false;
                   break;
     		 }
     		 else{
     			 Prime = true;
     			 break;
     		 }
     	 }
     	 return Prime;
       }
}