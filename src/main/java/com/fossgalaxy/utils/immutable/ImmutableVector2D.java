package com.fossgalaxy.utils.immutable;

import com.fossgalaxy.utils.Vector;
import com.fossgalaxy.utils.mutable.Vector2D;

/**
 * Version of the ImmutableVector class with optimisations for 2D Vectors.
 */
public class ImmutableVector2D extends ImmutableVector {
	public static final Integer SIZE = 2;
	public static final Integer X = 0;
	public static final Integer Y = 1;
	
	//common vectors (useful for saving memory)
	public static final ImmutableVector2D ZERO = new ImmutableVector2D(0,0);
	
	
	public ImmutableVector2D(double x, double y) {
		super(SIZE, x, y);
	}
	
	public ImmutableVector2D(Vector vector) {
		super(vector);
	}
	
	public double getX() {
		return parts[X];
	}
	
	public double getY() {
		return parts[Y];
	}
	
	@Override
	public ImmutableVector2D getCopy() {
		return this;
	}
	
	@Override
	public Vector2D getMutableCopy() {
		return new Vector2D(parts[X], parts[Y]);
	}
	
	@Override
	public double magnatude() {
		return Math.hypot(parts[X], parts[Y]);
	}
}
