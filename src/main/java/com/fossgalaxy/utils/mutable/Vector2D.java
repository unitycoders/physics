package com.fossgalaxy.utils.mutable;

import com.fossgalaxy.utils.Vector;

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
	
	public double getX() {
		return parts[X];
	}
	
	public double getY() {
		return parts[Y];
	}

}
