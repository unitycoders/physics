package com.fossgalaxy.utils.immutable;

import com.fossgalaxy.utils.AbstractVector;
import com.fossgalaxy.utils.Vector;
import com.fossgalaxy.utils.mutable.MutableVector;
import com.fossgalaxy.utils.mutable.MutableVectorI;

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
	public ImmutableVector multiply(Vector other) {
		
		double[] results = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			results[i] = parts[i] * other.getComponent(i);
		}
		
		return new ImmutableVector(parts.length, results);
	}

	@Override
	public ImmutableVector multiply(double other) {
		
		double[] results = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			results[i] = parts[i] * other;
		}
		
		return new ImmutableVector(parts.length, results);
	}
	
	@Override
	public ImmutableVector add(Vector other) {
		return add(other, 1);
	}

	@Override
	public ImmutableVector add(Vector other, double factor) {
		double[] results = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			results[i] = parts[i] + (other.getComponent(i) * factor);
		}
		
		return new ImmutableVector(parts.length, results);
	}
	
	@Override
	public ImmutableVector subtract(Vector other) {
		return add(other, -1);
	}

	@Override
	public ImmutableVector subtract(Vector other, double factor) {
		return add(other, -factor);
	}

	@Override
	public ImmutableVector wrap(double ... limits) {
		if (limits == null || limits.length != parts.length) {
			throw new IllegalArgumentException("Incorrect number of limits provided");
		}
		
		boolean changed = false;
		double[] results = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			results[i] = parts[i] % limits[i];
			
			if ( results[i] != parts[i] ) {
				changed = true;
			}
		}
		
		if (!changed) {
			return this;
		} else {
			return new ImmutableVector(results.length, results);
		}
	}

	@Override
	public ImmutableVector normalise() {
		double length = magnatude();
		
		if (length == 1) {
			return this;
		}
		
		double[] result = new double[parts.length];
		for (int i=0; i<parts.length; i++) {
			result[i] = parts[i] / length;
		}
		
		return new ImmutableVector(result.length, result);
	}

	@Override
	public ImmutableVector limit(double limit) {
		return normalise().multiply(limit);
	}

	@Override
	public ImmutableVector rotate(double rads) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImmutableVector rotateDeg(double deg) {
		return rotate(Math.toRadians(deg));
	}

	@Override
	public double distance(Vector other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ImmutableVector getCopy() {
		//we don't need to copy immutable vectors, they can't be changed
		return this;
	}
	
	public MutableVectorI getMutableCopy() {
		return new MutableVector(parts.length, parts);
	}
	
}
