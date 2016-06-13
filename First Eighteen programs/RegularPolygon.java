package io.github.xieyezi;
public class RegularPolygon {
      private int n = 3;
      private double side = 1.0;
      private double x = 0.0;
      private double y = 0.0;
      RegularPolygon(){
    	  this.n = n;
    	  this.side = side;
      }
      RegularPolygon(int n,double side) {
    	  this.x= x;
    	  this.y = y;
    	  this.n = n;
    	  this.side = side;
      }
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
    public double getPerimeter(){
    	  return n*side;
      }
    public double getArea() {
    	return (n*side*side)/(4*Math.tan(Math.PI/n));
    }
    public static void main(String[] args) {
    	RegularPolygon b = new RegularPolygon(6,4.0);
    	RegularPolygon c = new RegularPolygon(10,4.0);
    	RegularPolygon a = new RegularPolygon();
    	c.x = 5.6;
    	c.y = 7.8;
    	System.out.println(a.getPerimeter()+" "+a.getArea());
    	System.out.println(b.getPerimeter()+" "+b.getArea());
    	System.out.println(c.getPerimeter()+" "+c.getArea());
	}
}
