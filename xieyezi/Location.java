package io.github.xieyezi;

import java.util.Scanner;

public class Location {
      public static int raw=0,col=0;
      public static double maxValue=0.0;
      Location(double arr[][],int raw,int col) {  
    	  
      }
      public static Location locateLargest(double [][]arr) {
    	  Location a = new Location(arr,raw,col);
    	  for(int i = 0;i<arr.length;i++) {
    		  for(int j = 0;j<arr[i].length;j++) {
    			  if(arr[i][j]>maxValue){
    				  maxValue = arr[i][j];
    				  raw = i;
    				  col = j;
    			  }   			  
    		  }
    	  }
    	  return a;
      }
      public static void main(String[] args) {
    	  Scanner input = new Scanner(System.in);
    	  System.out.println("Enter the number of raw and col: ");
    	 int raw = input.nextInt();
    	 int col = input.nextInt();
    	 double arr[][] = new double [raw][col];
    	 for(int i = 0;i<arr.length;i++) {
   		  for(int j = 0;j<arr[i].length;j++) {
   			 arr[i][j] = input.nextDouble();
   		  }
    	 }
		Location a =locateLargest(arr);
		System.out.println("the location of the lagerst element is "+a.maxValue+" at ("+a.raw+","+a.col+")");
	}
}
