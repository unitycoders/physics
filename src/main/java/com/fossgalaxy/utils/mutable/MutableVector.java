package com.fossgalaxy.utils.mutable;

import com.fossgalaxy.utils.AbstractVector;
import com.fossgalaxy.utils.Vector;
import com.fossgalaxy.utils.immutable.ImmutableVector;

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
	public MutableVector multiply(Vector other) {
		for (int i=0; i<parts.length; i++) {
			parts[i] *= other.getComponent(i);
		}
		return this;
	}

	@Override
	public MutableVector multiply(double other) {
		for (int i=0; i<parts.length; i++) {
			parts[i] *= other;
		}
		
		return this;
	}

	@Override
	public double dot(Vector other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MutableVector add(Vector other) {
		return add(other, 1);
	}

	@Override
	public MutableVector add(Vector other, double factor) {
		for (int i=0; i<parts.length; i++) {
			parts[i] += (other.getComponent(i) * factor);
		}
		
		return this;
	}

	@Override
	public MutableVector subtract(Vector other) {
		return subtract(other, 1);
	}

	@Override
	public MutableVector subtract(Vector other, double factor) {
		for (int i=0; i<parts.length; i++) {
			parts[i] -= (other.getComponent(i) * factor);
		}
		return this;
	}

	@Override
	public MutableVector wrap(double ... limits) {
		if (limits == null || limits.length != parts.length) {
			throw new IllegalArgumentException("Incorrect number of limits provided");
		}
		
		for (int i=0; i<parts.length; i++) {
			parts[i] = Math.max(parts[i], limits[i]);
		}
		
		return this;
	}

	@Override
	public MutableVector normalise() {
		double length = magnitude();
		
		for (int i=0; i<parts.length; i++) {
			parts[i] /= length;
		}

		return this;
	}

	@Override
	public MutableVector limit(double limit) {
		return normalise().multiply(limit);
	}

	@Override
	public MutableVector rotate(double rads) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public MutableVector rotateDeg(double deg) {
		return rotate(Math.toRadians(deg));
	}

	@Override
	public double distance(Vector other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MutableVector getCopy() {
		return new MutableVector(this);
	}
	
	@Override
	public void setComponent(int i, double newVal) {
		parts[i] = newVal;
	}

	@Override
	public ImmutableVector getImmutableCopy() {
		return new ImmutableVector(parts.length, parts);
	}

	@Override
	public MutableVector negative() {
		for (int i=0; i<parts.length; i++) {
			parts[i] = -parts[i];
		}
		
		return this;
	}
	
}
