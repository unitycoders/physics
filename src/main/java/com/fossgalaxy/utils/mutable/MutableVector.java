package com.fossgalaxy.utils.mutable;

import com.fossgalaxy.utils.AbstractVector;
import com.fossgalaxy.utils.Vector;

/**
 * A mutable n-dimensional vector class.
 * 
 * This vector will modifiy and return it's self as the argument
 * to the maths functions.
 */
public class MutableVector extends AbstractVector implements MutableVectorI {
	
	public MutableVector(int n, double ... parts){
		super(n, parts);
	}
	
	public MutableVector(Vector vector) {
		super(vector);
	}

	@Override
	public Vector multiply(Vector other) {
		
		for (int i=0; i<parts.length; i++) {
			parts[i] *= other.getComponent(i);
		}
		
		return this;
	}

	@Override
	public Vector multiply(double other) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public double dot(Vector other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector add(Vector other) {
		return add(other, 1);
	}

	@Override
	public Vector add(Vector other, double factor) {
		for (int i=0; i<parts.length; i++) {
			parts[i] += (other.getComponent(i) * factor);
		}
		
		return this;
	}

	@Override
	public Vector subtract(Vector other) {
		return subtract(other, 1);
	}

	@Override
	public Vector subtract(Vector other, double factor) {
		for (int i=0; i<parts.length; i++) {
			parts[i] += (other.getComponent(i) * factor);
		}
		return this;
	}

	@Override
	public Vector wrap(double width, double height) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Vector normalise() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Vector limit(double limit) {
		return normalise().multiply(limit);
	}

	@Override
	public Vector rotate(double rads) {
		// TODO Auto-generated method stub
		return this;
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
		return new MutableVector(this);
	}
	
	@Override
	public void setComponent(int i, double newVal) {
		parts[i] = newVal;
	}
	
}
