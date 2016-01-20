package com.fossgalaxy.utils;

public interface Vector {
	
	public int getDimensions();
	
	public Vector multiply(Vector other);
	public Vector multiply(double other);
	
	public double dot(Vector other);
	
	public Vector add(Vector other);
	public Vector add(Vector other, double factor);

	public Vector subtract(Vector other);
	public Vector subtract(Vector other, double factor);
	
	public Vector wrap(double ... limits);
	
	public Vector normalise();
	public Vector limit(double limit);
	
	public Vector rotate(double rads);
	public Vector rotateDeg(double deg);
	
	public double magnatude();
	public double distance(Vector other);
	
	public double getComponent(int i);
	
	public Vector getCopy();
	
	public Vector negative();
}
