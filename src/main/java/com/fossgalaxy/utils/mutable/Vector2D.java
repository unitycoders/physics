package com.fossgalaxy.utils.mutable;

import com.fossgalaxy.utils.Vector;

/**
 * Version of the MutableVector class with optimisations for 2D Vectors.
 */
public class Vector2D extends MutableVector {
	public static final Integer SIZE = 2;
	public static final Integer X = 0;
	public static final Integer Y = 1;
	
	public Vector2D() {
		super(SIZE, 0, 0);
	}
	
	public Vector2D(double x, double y) {
		super(SIZE, x, y);
	}
	
	public Vector2D(Vector vector) {
		super(vector);
	}
	
	public void set(double x, double y) {
		parts[X] = x;
		parts[Y] = y;
	}
	
	public double getX() {
		return parts[X];
	}
	
	public double getY() {
		return parts[Y];
	}

	@Override
	public Vector2D getCopy() {
		return new Vector2D(parts[X], parts[Y]);
	}
	
	@Override
	public double magnitude() {
		return Math.hypot(parts[X], parts[Y]);
	}
	
}
