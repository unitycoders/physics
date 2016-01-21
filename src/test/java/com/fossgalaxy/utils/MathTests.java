package com.fossgalaxy.utils;

import static org.junit.Assert.*;

import com.fossgalaxy.utils.mutable.Vector2D;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fossgalaxy.utils.mutable.MutableVector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static junitparams.JUnitParamsRunner.$;

/**
 * Math tests.
 * <p/>
 * Piers, write your test cases for 2D vectors here :).
 */
@RunWith(JUnitParamsRunner.class)
public class MathTests {

    public static final Double DELTA = 0.0001;

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

    @Test
    @Parameters(method = "parametersForAdd")
    public void testAdd(Vector2D a, Vector2D b, Vector2D expected) {
        assertEquals(expected, a.add(b));
    }

    public Object[] parametersForAdd() {
        return $(
                $(new Vector2D(1, 0), new Vector2D(0, 1), new Vector2D(1, 1)),
                $(new Vector2D(2, 3), new Vector2D(2, 3), new Vector2D(4, 6)),
                $(new Vector2D(.5, .5), new Vector2D(0.2, 1), new Vector2D(.7, 1.5)),
                $(new Vector2D(-1, -1), new Vector2D(0, 1), new Vector2D(-1, 0))
        );
    }

    @Test
    @Parameters(method="parametersForWeightedAdd")
    public void testWeightedAdd(Vector2D a, Vector2D b, double factor, Vector2D expected){
        assertEquals(expected, a.add(b, factor));
    }

    public Object[] parametersForWeightedAdd(){
        return $(
                $(new Vector2D(1, 0), new Vector2D(0, 1), 1, new Vector2D(1, 1)),
                $(new Vector2D(2, 3), new Vector2D(2, 3), 2, new Vector2D(6, 9)),
                $(new Vector2D(.5, .5), new Vector2D(0.2, 1), -1, new Vector2D(.3, -0.5)),
                $(new Vector2D(-1, -1), new Vector2D(0, 1), 0.5, new Vector2D(-1, -0.5))
        );
    }

    @Test
    @Parameters(method="parametersForSubtract")
    public void testSubtract(Vector2D a, Vector2D b, Vector2D expected){
        assertEquals(expected, a.subtract(b));
    }

    public Object[] parametersForSubtract(){
        return $(
                $(new Vector2D(1, 0), new Vector2D(0, 1), new Vector2D(1, -1)),
                $(new Vector2D(0, 1), new Vector2D(1, 0), new Vector2D(-1, 1)),
                $(new Vector2D(0, 0), new Vector2D(-1, -1), new Vector2D(1, 1))
        );
    }

    @Test
    @Parameters(method="parametersForWeightedSubtract")
    public void testWeightedSubtract(Vector2D a, Vector2D b, double factor, Vector2D expected){
        assertEquals(expected, a.subtract(b, factor));
    }

    public Object[] parametersForWeightedSubtract(){
        return $(
                $(new Vector2D(1, 0), new Vector2D(0, 1), 1, new Vector2D(1, -1)),
                $(new Vector2D(0, 1), new Vector2D(1, 0), -1, new Vector2D(1, 1)),
                $(new Vector2D(0, 0), new Vector2D(-1, -1), 0.5, new Vector2D(0.5, 0.5))
        );
    }

    @Test
    @Parameters(method="parametersForMagnitude")
    public void testMagnitude(Vector2D a, double expected){
        assertEquals(expected, a.magnitude(), DELTA);
    }

    public Object[] parametersForMagnitude(){
        return $(
                $(new Vector2D(0, 1), 1),
                $(new Vector2D(1, 0), 1),
                $(new Vector2D(1, 1), Math.sqrt(2)),
                $(new Vector2D(3, 4), 5),
                $(new Vector2D(-3, 4), 5),
                $(new Vector2D(3, -4), 5),
                $(new Vector2D(-3, -4), 5)
        );
    }
}