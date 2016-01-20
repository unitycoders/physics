package com.fossgalaxy.utils;

import java.util.Arrays;

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

	public Vector getCopy() {
		return new MutableVector(this);
	}

	public void setComponent(int i, double newVal) {
		parts[i] = newVal;
	}
	
}
