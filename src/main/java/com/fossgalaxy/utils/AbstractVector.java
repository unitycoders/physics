package com.fossgalaxy.utils;

import java.util.Arrays;

/**
 * Abstract vector.
 *
 * provides things common to both immutable and mutable vectors.
 */
public abstract class AbstractVector implements Vector {
	
	protected final double[] parts;
	
	public AbstractVector(int n, double ... parts){
		if (parts == null || parts.length != n) {
			throw new IllegalArgumentException("incorrect number of parts provided");
		}
		
		this.parts = Arrays.copyOf(parts, n);
	}
	
	public AbstractVector(Vector vector) {
		this.parts = new double[vector.getDimensions()];
		for (int i=0; i<parts.length; i++) {
			parts[i] = vector.getComponent(i);
		}
	}

	public int getDimensions() {
		return parts.length;
	}

	public double getComponent(int i) {
		if (i < 0 || i > parts.length) {
			throw new IllegalArgumentException("invalid component");
		}
		
		return parts[i];
	}

	public abstract Vector getCopy();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		for (int i=0; i<parts.length; i++) {
			sb.append(parts[i]);
			if (i != parts.length-1) {
				sb.append(",");
			}
		}
		sb.append(">");
		
		return sb.toString();
	}
}
