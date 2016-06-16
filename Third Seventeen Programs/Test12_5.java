package io.xieyezi.github;

import java.util.Scanner;

public class Test12_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("请输入三角形的三条边:");
			double side1 = input.nextDouble();
			double side2 = input.nextDouble();
			double side3 = input.nextDouble();
			Triangle triangle = new Triangle(side1, side2, side3);
			System.out.println(triangle.toString());
			System.out.println("Perimeter = " + triangle.getPerimeter());
			System.out.println("Area = " + triangle.getArea());
		} catch (IllegalTriangleException ex) {
			System.out.println(ex);
		} finally {
			input.close();
		}

	}
}

	class IllegalTriangleException extends Exception {
		private double side1, side2, side3;

		public IllegalTriangleException(double side1, double side2, double side3) {
			super(side1 + " " + side2 + " " + side3 + " can not form a triangle!");
			this.side1 = side1;
			this.side1 = side2;
			this.side1 = side3;
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

	}

	class GeometricObject {
		private String color = "white";
		private boolean filled;
		private java.util.Date dateCreated;

		public GeometricObject() {
			dateCreated = new java.util.Date();
		}

		public GeometricObject(String color, boolean filled) {
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
			return "created on" + dateCreated + "\ncolor" + color + "and filled" + filled;
		}

	}

	class Triangle extends GeometricObject {
		private double side1;
		private double side2;
		private double side3;

		public Triangle() throws IllegalTriangleException {
			this(1.0, 1.0, 1.0);
		}

		public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
			if ((side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1)) {
				this.side1 = side1;
				this.side1 = side2;
				this.side1 = side3;
			} else
				throw new IllegalTriangleException(side1, side2, side3);
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

		public double getArea() {
			double s = (side1 + side2 + side3) / 2.0;
			return Math.pow((s * (s - side1) * (s - side2) * (s - side3)), 0.5);
		}

		public double getPerimeter() {
			return side1 + side2 + side3;
		}

		@Override
		public String toString() {
			return "Triangle: side1 =  " + side1 + " side2 = " + side2 + " side3 = " + side3;
		}

	}
