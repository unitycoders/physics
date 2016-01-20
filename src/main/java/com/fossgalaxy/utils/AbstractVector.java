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

	@Override
	public double dot(Vector other) {
		
		double result = 0;
		for (int i=0; i<parts.length; i++) {
			result += parts[i] * other.getComponent(i);
		}
		
		return result;
	}
	
	@Override
	public double magnitude() {
		double length = 0;
		
		for (int i=0; i<parts.length; i++) {
			length += Math.pow(parts[i], 2);
		}
		
		return Math.sqrt(length);
	}
	
	@Override
	public int getDimensions() {
		return parts.length;
	}
	
	@Override
	public double getComponent(int i) {
		if (i < 0 || i > parts.length) {
			throw new IllegalArgumentException("invalid component");
		}
		
		return parts[i];
	}
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(parts);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractVector other = (AbstractVector) obj;
		if (!Arrays.equals(parts, other.parts))
			return false;
		return true;
	}

}
