package com.fossgalaxy.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fossgalaxy.utils.mutable.MutableVector;

public class BaseVectorTests {
	//error margin for double checks
	private static Double EPISLON = 1e-15;
	
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
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorFailNone() {
		int arity = 2;	
		Vector testVector = new MutableVector(arity);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorFailNull() {
		int arity = 2;	
		double[] args = null;
		
		Vector testVector = new MutableVector(arity, args);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorFailTooFew() {
		int arity = 2;
		double x = 1;
		
		Vector testVector = new MutableVector(arity,x);
	}
	
	@Test
	public void testConstructorWorks() {
		int arity = 2;
		double x = 1;
		double y = 2;
		
		Vector testVector = new MutableVector(arity,x,y);
		assertEquals(arity, testVector.getDimensions());
		assertEquals(x, testVector.getComponent(0), EPISLON);
		assertEquals(y, testVector.getComponent(1), EPISLON);
	}
	
	@Test
	public void testConstructorWorksArray() {
		int arity = 2;
		double x = 1;
		double y = 2;
		double[] args = {x,y};
		
		Vector testVector = new MutableVector(arity,args);
		assertEquals(arity, testVector.getDimensions());
		assertEquals(x, testVector.getComponent(0), EPISLON);
		assertEquals(y, testVector.getComponent(1), EPISLON);
	}
	
	@Test
	public void testConstructorWorksArrayCopy() {
		int arity = 2;
		double x = 1;
		double y = 2;
		double[] args = {x,y};
		Vector testVector = new MutableVector(arity,args);
		
		//this should have no effect on the result
		args[0]++;
		args[1]++;
		
		assertEquals(arity, testVector.getDimensions());
		assertEquals(x, testVector.getComponent(0), EPISLON);
		assertEquals(y, testVector.getComponent(1), EPISLON);
		
		System.out.println(testVector.getComponent(0)+":"+testVector.getComponent(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorFailTooFewMany() {
		int arity = 2;
		double x = 1;
		double y = 2;
		double z = 3;
		
		Vector testVector = new MutableVector(arity,x,y,z);
	}
}
