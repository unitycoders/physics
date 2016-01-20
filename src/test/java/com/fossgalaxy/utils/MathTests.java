package com.fossgalaxy.utils;

import static org.junit.Assert.*;

import com.fossgalaxy.utils.mutable.Vector2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fossgalaxy.utils.mutable.MutableVector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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

@RunWith(Parameterized.class)
class AddTest{
    Vector2D a,b, expected;

    public AddTest(Vector2D a, Vector2D b, Vector2D expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {new Vector2D(1, 0), new Vector2D(0, 1), new Vector2D(1, 1)},
                {new Vector2D(2, 3), new Vector2D(2, 3), new Vector2D(4, 6)},
                {new Vector2D(.5, .5), new Vector2D(0.2, 1), new Vector2D(.7, 1.5)},
                {new Vector2D(-1, -1), new Vector2D(0, 1), new Vector2D(-1, 0)}
        });
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(expected, a.add(b));
    }
}