package test;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.TestCase;


import range.Range;

/**
 * Unit test for class Range
 * 
 * @author QuangLeDinh
 *
 */
public class RangeTest extends TestCase {

    /**
     * REQUIRE 1 
     * Case1: Check data contain in Range (normal)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testContain() {
        Range range = Range.of(1, 3);
        assertTrue(range.contains(2));
    }

    /**
     * REQUIRE 1 
     * Case2: Check data contain in Range (test lower bound)
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testContainLowerBound() {
        @SuppressWarnings("rawtypes")
        Range range = Range.of(1, 3);
        assertTrue(range.contains(1));
    }

    /**
     * REQUIRE 1 
     * Case3: Check data contain in Range (test upper bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testContainUpperBound() {
        Range range = Range.of(1, 3);
        assertTrue(range.contains(3));
    }

    /**
     * REQUIRE 1 
     * Case4: Check abnormal lowerbound > upperbound    
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testLowerBoundBiggerThanUpperBound() {
        try {
            Range range = Range.of(3, 1);
            assertTrue(range.contains(3));
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "wrong order, lowerbound > upperbound");
        }
    }

    /**
     * REQUIRE 2 
     * Case1: Check data contain in Open Range (Normal)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testOpenRange() {
        Range range = Range.open(1, 3);
        assertTrue(range.contains(2));
    }

    /**
     * REQUIRE 2 
     * Case2: Check data contain in Open Range (test lower bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testLowerBoundOpenRange() {
        Range range = Range.open(1, 3);
        assertFalse(range.contains(1));
    }

    /**
     * REQUIRE 2 
     * Case3: Check data contain in Open Range (test upper bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testUpperBoundOpenRange() {
        Range range = Range.open(1, 3);
        assertFalse(range.contains(3));
    }

    /**
     * REQUIRE 2 
     * Case4: Check data contain in Close Range (test lower bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testLowerBoundCloseRange() {
        Range range = Range.close(1, 3);
        assertTrue(range.contains(1));
    }

    /**
     * REQUIRE 2 
     * Case5: Check data contain in Close Range (test upper bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testUpperBoundCloseRange() {
        Range range = Range.close(1, 3);
        assertTrue(range.contains(3));
    }

    /**
     * REQUIRE 2 
     * Case6: Check data contain in Open Close Range (test lower bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testLowerBoundOpenCloseRange() {
        Range range = Range.openClose(1, 3);
        assertFalse(range.contains(1));
    }

    /**
     * REQUIRE 2 
     * Case7: Check data contain in Open Close Range (test upper bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testUpperBoundOpenCloseRange() {
        Range range = Range.openClose(1, 3);
        assertTrue(range.contains(3));
    }

    /**
     * REQUIRE 2 
     * Case8: Check data contain in Close Open Range (test lower bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testLowerBoundCloseOpenRange() {
        Range range = Range.closeOpen(1, 3);
        assertTrue(range.contains(1));
    }

    /**
     * REQUIRE 2 
     * Case9: Check data contain in Close Open Range (test upper bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testUpperBoundCloseOpenRange() {
        Range range = Range.closeOpen(1, 3);
        assertFalse(range.contains(3));
    }

    /**
     * REQUIRE 3
     * Case1: Check data contain in Range with String data type (normal)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testStringRange() {
        Range range = Range.open("abc", "xyz");
        assertTrue(range.contains("efg"));
    }

    /**
     * REQUIRE 3
     * Case1: Check data contain in Range with String data type (test lower bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testLowerBoundStringRange() {
        Range range = Range.open("abc", "xyz");
        assertFalse(range.contains("abc"));
    }

    /**
     * REQUIRE 3
     * Case1: Check data contain in Range with String data type (test upper bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testUpperBoundStringRange() {
        Range range = Range.close("abc", "xyz");
        assertTrue(range.contains("xyz"));
    }

    /**
     * REQUIRE 3
     * Case1: Check data contain in Range with BigDecimal data type (normal)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testBigDecimalRange() {
        Range range = Range.open(new BigDecimal(0.001), new BigDecimal(0.003));
        assertTrue(range.contains(new BigDecimal(0.002)));
    }

    /**
     * REQUIRE 3
     * Case1: Check data contain in Range with BigDecimal data type (test lower bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testLowerBoundBigDecimalRange() {
        Range range = Range.close(new BigDecimal(0.001), new BigDecimal(0.003));
        assertTrue(range.contains(new BigDecimal(0.001)));
    }

    /**
     * REQUIRE 3
     * Case1: Check data contain in Range with BigDecimal data type (test upper bound)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testUpperBoundBigDecimalRange() {
        Range range = Range.close(new BigDecimal(0.001), new BigDecimal(0.003));
        assertTrue(range.contains(new BigDecimal(0.003)));
    }
}
