package io.github.xieyezi;

import java.util.Scanner;

public class LinearEquation {
      private double a,b,c,d,e,f;
      LinearEquation(double a,double b,double c,double d,double e,double f) {
    	  this.a = a;
    	  this.b = b;
    	  this.c = c;
    	  this.d = d;
    	  this.e = e;
    	  this.f = f;
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
	public double getD() {
		return d;
	}
	public double getE() {
		return e;
	}
      public boolean isSolvable() {
    	  if((a*d-b*c)!=0)
    		  return true;
    	  else
    		  return false;
      }
      public double getX() {
    	  return (e*d-b*f)/(a*d-b*c);
      }
      public double getY() {
    	  return (a*f-e*c)/(a*d-b*c);
      }
      public static void main(String[] args) {
    	  double a,b,c,d,e,f;
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the a,b,c,d,e,f:");
      a = input.nextDouble();
      b = input.nextDouble();
      c = input.nextDouble();
      d = input.nextDouble();
      e = input.nextDouble();
      f = input.nextDouble();
      LinearEquation n = new LinearEquation(a,b,c,d,e,f);
      if(n.isSolvable()==true) {
    	  System.out.println("x= "+n.getX()+" y= "+n.getY());
      }
      else
    	  System.out.println("The equation has no solution.");
	}
}
