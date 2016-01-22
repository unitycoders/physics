package com.fossgalaxy.utils;

import com.fossgalaxy.utils.mutable.MutableVector;
import com.fossgalaxy.utils.mutable.Vector2D;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

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
    @Parameters(method = "parametersForWeightedAdd")
    public void testWeightedAdd(Vector2D a, Vector2D b, double factor, Vector2D expected) {
        assertEquals(expected, a.add(b, factor));
    }

    public Object[] parametersForWeightedAdd() {
        return $(
                $(new Vector2D(1, 0), new Vector2D(0, 1), 1, new Vector2D(1, 1)),
                $(new Vector2D(2, 3), new Vector2D(2, 3), 2, new Vector2D(6, 9)),
                $(new Vector2D(.5, .5), new Vector2D(0.2, 1), -1, new Vector2D(.3, -0.5)),
                $(new Vector2D(-1, -1), new Vector2D(0, 1), 0.5, new Vector2D(-1, -0.5))
        );
    }

    @Test
    @Parameters(method = "parametersForSubtract")
    public void testSubtract(Vector2D a, Vector2D b, Vector2D expected) {
        assertEquals(expected, a.subtract(b));
    }

    public Object[] parametersForSubtract() {
        return $(
                $(new Vector2D(1, 0), new Vector2D(0, 1), new Vector2D(1, -1)),
                $(new Vector2D(0, 1), new Vector2D(1, 0), new Vector2D(-1, 1)),
                $(new Vector2D(0, 0), new Vector2D(-1, -1), new Vector2D(1, 1))
        );
    }

    @Test
    @Parameters(method = "parametersForWeightedSubtract")
    public void testWeightedSubtract(Vector2D a, Vector2D b, double factor, Vector2D expected) {
        assertEquals(expected, a.subtract(b, factor));
    }

    public Object[] parametersForWeightedSubtract() {
        return $(
                $(new Vector2D(1, 0), new Vector2D(0, 1), 1, new Vector2D(1, -1)),
                $(new Vector2D(0, 1), new Vector2D(1, 0), -1, new Vector2D(1, 1)),
                $(new Vector2D(0, 0), new Vector2D(-1, -1), 0.5, new Vector2D(0.5, 0.5))
        );
    }

    @Test
    @Parameters(method = "parametersForMagnitude")
    public void testMagnitude(Vector2D a, double expected) {
        assertEquals(expected, a.magnitude(), DELTA);
    }

    public Object[] parametersForMagnitude() {
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

    @Test
    @Parameters(method = "parametersForNormalise")
    public void testNormalise(Vector2D a) {
        a.normalise();
        assertEquals(1, a.magnitude(), DELTA);
    }

    public Object[] parametersForNormalise() {
        return $(
                $(new Vector2D(0, 1)),
                $(new Vector2D(1, 0)),
                $(new Vector2D(5, 6)),
                $(new Vector2D(-3, 3)),
                $(new Vector2D(3, -3)),
                $(new Vector2D(-3, -3))
        );
    }

    @Test
    @Parameters(method = "parametersForTestLimit")
    public void testLimit(Vector2D a, double limit, double expected) {
        a.limit(limit);
        assertEquals(expected, a.magnitude(), DELTA);
    }

    public Object[] parametersForTestLimit() {
        return $(
                $(new Vector2D(0, 1), 1, 1),
                $(new Vector2D(0, 1), 3, 1),
                $(new Vector2D(3, 4), 5, 5),
                $(new Vector2D(3, 4), 3, 3)
        );
    }

    @Test
    @Parameters(method = "parametersForTestWrap")
    public void testWrap(Vector2D a, double xLim, double yLim, Vector2D expected) {
        a.wrap(xLim, yLim);
        assertEquals(expected, a);
    }

    public Object[] parametersForTestWrap() {
        return $(
                $(new Vector2D(0, 1), 5, 5, new Vector2D(0, 1)),
                $(new Vector2D(200, 200), 150, 150, new Vector2D(50, 50))
        );
    }


    @Test
    @Parameters(method = "parametersForTestDistance")
    public void testDistance(Vector2D a, Vector2D b, double expected) {
        double distance = a.distance(b);
        assertEquals(expected, distance, DELTA);
    }

    public Object[] parametersForTestDistance() {
        return $(
                $(new Vector2D(0, 0), new Vector2D(0, 1), 1),
                $(new Vector2D(0, 0), new Vector2D(1, 0), 1),
                $(new Vector2D(1, 1), new Vector2D(0, 0), Math.sqrt(2)),
                $(new Vector2D(3, 4), new Vector2D(0, 0), 5),
                $(new Vector2D(0, 0), new Vector2D(3, 4), 5)
        );
    }

    @Test
    @Parameters(method = "parametersForTestRotate")
    public void testRotate(Vector2D a, double rotationAmount, Vector2D expected) {
        a.rotate(rotationAmount);
        assertEquals(expected, a);
    }

    public Object[] parametersForTestRotate() {
        return $(
                $(new Vector2D(0, 1), Math.toRadians(90), new Vector2D(1, 0)),
                $(new Vector2D(0, 1), Math.toRadians(360), new Vector2D(0, 1)),
                $(new Vector2D(0, 1), Math.toRadians(-90), new Vector2D(-1, 0)),
                $(new Vector2D(0, 1), Math.toRadians(360 + 90), new Vector2D(1, 0))
        );
    }

    @Test
    @Parameters(method = "parametersForTestRotateDeg")
    public void testRotateDeg(Vector2D a, double rotationAmount, Vector2D expected) {
        a.rotateDeg(rotationAmount);
        assertEquals(expected, a);
    }

    public Object[] parametersForTestRotateDeg() {
        return $(
                $(new Vector2D(0, 1), 90, new Vector2D(1, 0)),
                $(new Vector2D(0, 1), 360, new Vector2D(0, 1)),
                $(new Vector2D(0, 1), -90, new Vector2D(-1, 0)),
                $(new Vector2D(0, 1), 360 + 90, new Vector2D(1, 0))
        );
    }

    @Test
    @Parameters(method = "parametersForTestDot")
    public void testDot(Vector2D a, Vector2D b, double expected) {
        double dot = a.dot(b);
        assertEquals(expected, dot, DELTA);
    }

    public Object[] parametersForTestDot() {
        return $(
                $(new Vector2D(0, 1), new Vector2D(1, 0), 0),
                $(new Vector2D(3, 4), new Vector2D(5, 6), 39),
                $(new Vector2D(-3, -4), new Vector2D(-5, -6), 39),
                $(new Vector2D(-3, 4), new Vector2D(-5, 6), 39),
                $(new Vector2D(-3, -4), new Vector2D(5, 6), -39)
        );
    }

    @Test
    @Parameters(method = "parametersForNegative")
    public void testNegative(Vector2D a, Vector2D expected) {
        a.negative();
        assertEquals(a, expected);
    }

    public Object[] parametersForNegative() {
        return $(
                $(new Vector2D(0, 0), new Vector2D(0, 0)),
                $(new Vector2D(1, 1), new Vector2D(-1, -1)),
                $(new Vector2D(-1, -1), new Vector2D(1, 1))
        );
    }

    @Test
    @Parameters(method = "parametersForTestCopy")
    public void testGetCopy(Vector2D a){
        Vector2D b = a.getCopy();
        assertEquals(true, a.equals(b));
        b.add(new Vector2D(1, 1));
        assertEquals(false, a.equals(b));
    }

    public Object[] parametersForTestCopy(){
        return $(
                new Vector2D(0, 0),
                new Vector2D(1, 1),
                new Vector2D(-2, -2)
        );
    }

}