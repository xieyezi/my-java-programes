package io.github.xieyezi;

import java.util.Scanner;
//ÓÐ´ýÐÞ¸Ä
public class Test11_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of the points:");
		int n = input.nextInt();
		double a[] = new double[n];
		double b[] = new double[n];
		System.out.println("Enter the coordinates of the points:");
		for(int i =0;i<n;i++){
			a[i] = input.nextDouble();
			b[i] = input.nextDouble();
		}
		input.close();
		System.out.println("The total area is:"+getArea(a,b,n));
	}
    public static double getArea(double a[],double b[],int n){
    	double sum1 = 0.0;
    	double sum2 = 0.0;
    	for(int i = 1;i<b.length;i++){
    		sum1 += b[i];
    	}
    	for(int j = 1;j<a.length;j++){
    		sum2 += a[j];
    	}
    	return Math.abs((a[0]*sum1-b[0]*sum2)/2);
    }
}
