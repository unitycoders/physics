package com.fossgalaxy.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Math tests.
 * 
 * Piers, write your test cases for 2D vectors here :).
 */
public class MathTests {

	private Vector testVector;
	
	@Before
	public void setup() {
		this.testVector = new MutableVector(2, 0, 0);
	}
	
	@After
	public void tearDown() {
		testVector = null;
		assertNull(testVector);
	}
	
	@Test
	public void unfailableTest() {
		assertTrue(true);
	}
	
}