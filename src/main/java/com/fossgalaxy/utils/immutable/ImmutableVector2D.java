package com.fossgalaxy.utils.immutable;

import com.fossgalaxy.utils.Vector;

public class ImmutableVector2D extends ImmutableVector {
	public static final Integer SIZE = 2;
	public static final Integer PART_X = 0;
	public static final Integer PART_Y = 1;
	
	//common vectors (useful for saving memory)
	public static final ImmutableVector2D ZERO = new ImmutableVector2D(0,0);
	
	
	public ImmutableVector2D(double x, double y) {
		super(SIZE, x, y);
	}
	
	public ImmutableVector2D(Vector vector) {
		super(vector);
	}
	
	public double getX() {
		return parts[PART_X];
	}
	
	public double getY() {
		return parts[PART_Y];
	}
}
