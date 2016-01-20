package com.fossgalaxy.utils;

import java.util.Arrays;

/**
 * A mutable n-dimensional vector class.
 * 
 * This vector will modifiy and return it's self as the argument
 * to the maths functions.
 */
public class MutableVector implements Vector {

	protected final double[] parts;
	private int n;
	
	public MutableVector(int n, double ... parts){
		if (parts == null || parts.length != n) {
			throw new IllegalArgumentException("incorrect number of parts provided");
		}
		
		this.n = n;
		this.parts = Arrays.copyOf(parts, n);
	}
	
	public MutableVector(Vector vector) {
		this.n = vector.getDimensions();
		this.parts = new double[n];
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
		
		return parts[i];
	}

	public Vector getCopy() {
		return new MutableVector(this);
	}
	
}
