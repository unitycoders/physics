package com.fossgalaxy.utils.mutable;

import com.fossgalaxy.utils.Vector;
import com.fossgalaxy.utils.immutable.ImmutableVector;

public interface MutableVectorI extends Vector {
	
	public void setComponent(int i, double newVal);

	public ImmutableVector getImmutableCopy();
	
}
