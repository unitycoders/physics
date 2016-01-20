package com.fossgalaxy.utils;

public class BaseVector implements Vector {

	private double[] parts;
	private int n;
	
	public BaseVector(int n, double ... parts){
		this.n = n;
		this.parts = parts;
	}
	
	public BaseVector(Vector vector) {
		this.n = vector.getDimensions();
		for (int i=0; i<n; i++) {
			parts[i] = vector.getComponent(i);
		}
	}

	public int getDimensions() {
		return n;
	}

	public Vector multiply(Vector other) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector multiply(double other) {
		// TODO Auto-generated method stub
		return null;
	}

	public double dot(Vector other) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Vector add(Vector other) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector add(Vector other, double factor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector subtract(Vector other) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector subtract(Vector other, double factor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector wrap(double width, double height) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector normalise() {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector limit(double limit) {
		return normalise().multiply(limit);
	}

	public Vector rotate(double rads) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector rotateDeg(double deg) {
		return rotate(Math.toRadians(deg));
	}

	public double magnatude() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double distance(Vector other) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getComponent(int i) {
		if (i < 0 || i > parts.length) {
			throw new IllegalArgumentException("invalid component");
		}
		
		return i;
	}

	public Vector getCopy() {
		return new BaseVector(this);
	}
	
}
