package io.github.xieyezi;
public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    public int getSpeed() {
    	return speed;
    }
    public boolean getOn() {
    	return on;
    }
    public double getRadius(){
    	return radius;
    }
    public String getColor() {
    	return color;
    }
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void setColor(String color) {
		this.color = color;
	}
	Fan(){
		this.on = on;
		this.speed = speed;
		this.radius = radius;
		this.color = color;
	}
	public String toString(Fan fan) {
		if(this.on == true) 
			return this.speed+" "+this.color+" "+this.radius;
		else
			return "fan is off"+" "+this.color+" "+this.radius;
	}
	public static void main(String[] args) {
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		fan1.speed = FAST;
		fan1.radius = 10.0;
		fan1.color = "yellow";
		fan1.on = true;
		fan2.speed = MEDIUM;
		fan2.radius = 5.0;
		fan2.color = "blue";
		fan2.on = false;
		System.out.println(fan1.toString(fan1));
		System.out.println(fan2.toString(fan2));
	}
    
}
