package com.fossgalaxy.utils.immutable;

import com.fossgalaxy.utils.AbstractVector;
import com.fossgalaxy.utils.Vector;

/**
 * An immutable n-dimensional vector class.
 * 
 * This vector class will always return immutable versions of the math functions.
 */
public class ImmutableVector extends AbstractVector {

	public ImmutableVector(int n, double ... parts){
		super(n, parts);
	}
	
	public ImmutableVector(Vector vector) {
		super(vector);
	}

	public Vector multiply(Vector other) {
		
		double[] results = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			results[i] = parts[i] * other.getComponent(i);
		}
		
		return new ImmutableVector(parts.length, results);
	}

	public Vector multiply(double other) {
		
		double[] results = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			results[i] = parts[i] * other;
		}
		
		return new ImmutableVector(parts.length, results);
	}

	public double dot(Vector other) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Vector add(Vector other) {
		double[] results = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			results[i] = parts[i] + other.getComponent(i);
		}
		
		return new ImmutableVector(parts.length, results);
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


	public Vector getCopy() {
		return new ImmutableVector(this);
	}
	
}
