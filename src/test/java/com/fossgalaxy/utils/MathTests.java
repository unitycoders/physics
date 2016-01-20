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


}

@RunWith(Parameterized.class)
class subtractTest {

    Vector2D a, b, expected;

    public subtractTest(Vector2D a, Vector2D b, Vector2D expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new Vector2D(1, 0), new Vector2D(0, 1), new Vector2D(1, -1)},
                {new Vector2D(0, 1), new Vector2D(1, 0), new Vector2D(-1, 1)},
                {new Vector2D(0, 0), new Vector2D(-1, -1), new Vector2D(1, 1)}
        });
    }

    @Test
    public void testSub() throws Exception {
        assertEquals(expected, a.subtract(b));
    }
}

@RunWith(Parameterized.class)
class subtractWeightedTest {

    Vector2D a, b, expected;
    double factor;

    public subtractWeightedTest(Vector2D a, Vector2D b, double factor, Vector2D expected) {
        this.a = a;
        this.b = b;
        this.factor = factor;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new Vector2D(1, 0), new Vector2D(0, 1), 1, new Vector2D(1, -1)},
                {new Vector2D(0, 1), new Vector2D(1, 0), -1, new Vector2D(1, 1)},
                {new Vector2D(0, 0), new Vector2D(-1, -1), 0.5, new Vector2D(0.5, 0.5)}
        });
    }

    @Test
    public void testSub() throws Exception {
        assertEquals(expected, a.subtract(b, factor));
    }
}

@RunWith(Parameterized.class)
class magnitudeTest {

    Vector2D a;
    double expected;

    public magnitudeTest(Vector2D a, double expected) {
        this.a = a;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new Vector2D(0, 1), 1},
                {new Vector2D(1, 0), 1},
                {new Vector2D(1, 1), Math.sqrt(2)},
                {new Vector2D(3, 4), 5},
                {new Vector2D(-3, 4), 5},
                {new Vector2D(3, -4), 5},
                {new Vector2D(-3, -4), 5}
        });
    }

    @Test
    public void testMag() throws Exception {
        assertEquals(expected, a.magnitude(), MathTests.DELTA);
    }
}