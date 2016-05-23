package io.github.xieyezi;

public class Rectangle {
     double width;
     double height;
    public Rectangle() {
    	 width = 1;
    	 height = 1;
     }
    public Rectangle(double width,double height) {
    	 this.width = width;
    	 this.height = height;
    }
    public double getArea() {
    	return width*height;
    }
    public double getPerimeter() {
    	return 2*(width+height);
    }
    public static void main(String[] args) {
		Rectangle a = new Rectangle(4,40);
		Rectangle b = new Rectangle(3.5,35.9);
		System.out.println(a.width);
		System.out.println(a.height);
		System.out.println(a.getArea());
		System.out.println(a.getPerimeter());
		System.out.println(b.width);
		System.out.println(b.height);
		System.out.println(b.getArea());
		System.out.println(b.getPerimeter());
	}
}
