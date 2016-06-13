package io.github.xieyezi;

import java.util.Scanner;

public class QuadraticEquation {
      private double a,b,c;
      QuadraticEquation(double a,double b,double c){
    	  this.a = a;
    	  this.b = b;
    	  this.c = c;
      }
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	public double getC() {
		return c;
	}
    public double getDiscriminant(){
    	return b*b-4*a*c;
    }
    public double getRoot1() {
    	if(b*b-4*a*c>=0)
    	return ((-b)+Math.pow((b*b-4*a*c), 0.5))/2*a;
    	else
    		return 0.0;
    }
    public double getRoot2() {
    	if(b*b-4*a*c>=0)
        	return ((-b)-Math.pow((b*b-4*a*c), 0.5))/2*a;
        	else
        		return 0.0;
    }
    public static void main(String[] args) {
    	double a,b,c;
    	Scanner input = new Scanner(System.in);
    	System.out.println("«Î ‰»Îa,b,c:");
    	a = input.nextDouble();
    	b = input.nextDouble();
    	c = input.nextDouble();
    	QuadraticEquation n = new QuadraticEquation(a,b,c);
    	if(n.getRoot1()!=0.0){
    	 System.out.println("x1 = "+n.getRoot1());
    	}
    	else{
    		System.out.println("the equation has no roots!");
    	}
    	if(n.getRoot2()!=0.0){
    	 System.out.println("x2 = "+n.getRoot2());
    	 }
    	else{
    		System.out.println("the equation has no roots!");
	    }
    }
}
