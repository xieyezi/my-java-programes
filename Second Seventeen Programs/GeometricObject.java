package io.github.xieyezi;

import java.util.Scanner;

public class GeometricObject {
     private String color = "white";
     private boolean filled;
     private java.util.Date dateCreated;
     public GeometricObject(){
    	 dateCreated = new java.util.Date();
     }
     public GeometricObject(String color,boolean filled){
    	 dateCreated = new java.util.Date();
    	 this.color = color;
    	 this.filled = filled;
     }
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	@Override
    public String toString() {
    	 return "created on"+dateCreated+"\ncolor"+color+"and filled"+filled;
    }
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("请输入三角形的三条边:");
    	double side1= input.nextDouble();
    	double side2= input.nextDouble();
    	double side3= input.nextDouble();
    	input.nextLine();
    	System.out.println("请输入三角形的颜色:");
    	String color = input.nextLine();
    	System.out.println("该三角形是否填充(true/false):");
    	boolean filled = input.nextBoolean();
    	input.close();
    	Triangle triangle = new Triangle(side1,side2,side3);
    	triangle.setColor(color);
    	triangle.setFilled(filled);
    	System.out.println(triangle.toString());
    	System.out.println("Perimeter = "+triangle.getPerimeter());
    	System.out.println("Perimeter = "+triangle.getArea());
    	System.out.println("color = "+triangle.getColor());
    	System.out.println("filed = "+triangle.isFilled());
	}
}
class Triangle extends GeometricObject{
	private double side1;
	private double side2; 
	private double side3;
	public Triangle(){
		this(1.0,1.0,1.0);
	}
	public Triangle(double side1,double side2,double side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	public double getArea(){
		double s = (side1+side2+side3)/2.0;
		return Math.pow((s*(s-side1)*(s-side2)*(s-side3)),0.5);
	}
	public double getPerimeter(){
		return side1+side2+side3;
	}
	@Override
	public String toString(){
		return "Triangle: side1 =  "+side1+" side2 = "+side2+" side3 = "+side3;
	}
	
}











