package io.github.xieyezi;

public class Mypoint {
     private double x=0.0,y=0.0;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
     Mypoint(double x,double y) {
    	 this.x =x;
    	 this.y = y;
     }
     public double distance(Mypoint point) {
    	 return Math.pow((point.x-this.x)*(point.x-this.x)+(point.y-this.y)*(point.y-this.y),0.5);
     }
     public double distance(double x,double y) {
    	 return Math.pow((x-this.x)*(x-this.x)+(y-this.y)*(y-this.y),0.5);
     }
     public static void main(String[] args) {
    	 Mypoint point = new Mypoint(0.0,0.0);
    	 System.out.println(point.distance(10, 30.5));
	}
}
