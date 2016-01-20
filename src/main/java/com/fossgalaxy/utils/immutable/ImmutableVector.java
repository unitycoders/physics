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

	@Override
	public Vector multiply(Vector other) {
		
		double[] results = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			results[i] = parts[i] * other.getComponent(i);
		}
		
		return new ImmutableVector(parts.length, results);
	}

	@Override
	public Vector multiply(double other) {
		
		double[] results = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			results[i] = parts[i] * other;
		}
		
		return new ImmutableVector(parts.length, results);
	}

	@Override
	public double dot(Vector other) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Vector add(Vector other) {
		double[] results = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			results[i] = parts[i] + other.getComponent(i);
		}
		
		return new ImmutableVector(parts.length, results);
	}

	@Override
	public Vector add(Vector other, double factor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Vector subtract(Vector other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector subtract(Vector other, double factor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector wrap(double width, double height) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector normalise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector limit(double limit) {
		return normalise().multiply(limit);
	}

	@Override
	public Vector rotate(double rads) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector rotateDeg(double deg) {
		return rotate(Math.toRadians(deg));
	}

	@Override
	public double magnatude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double distance(Vector other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector getCopy() {
		return new ImmutableVector(this);
	}
	
}
