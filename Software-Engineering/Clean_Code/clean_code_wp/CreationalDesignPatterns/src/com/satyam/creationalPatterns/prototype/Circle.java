package com.satyam.creationalPatterns.prototype;

public class Circle implements Prototype{
	int radius;
	String color;
	
	Circle(int radius, String color){
		this.radius = radius;
		this.color = color;
	}
	
	@Override
    public Circle clone() {
        return new Circle(this.radius, this.color);
    }

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + "]";
	}
}
