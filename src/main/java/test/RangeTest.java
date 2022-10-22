package test;

import org.junit.Test;
import junit.framework.TestCase;

/*
 * Author: LeDinhQuang
 */
import range.Range;

public class RangeTest extends TestCase {

    @Test
    public void testContain() {
        Range range = Range.of(1, 3);
        assertTrue(range.constains(2));
    }

    @Test
    public void testOpenRange() {
        Range range = Range.open(1, 3);
        assertTrue(range.constains(2));
    }

    @Test
    public void testCloseRange() {
        Range range = Range.close(1, 3);
        assertTrue(range.constains(1));
    }

    @Test
    public void testOpenCloseRange() {
        Range range = Range.openClose(1, 3);
        assertTrue(range.constains(3));
    }

    @Test
    public void testCloseOpenRange() {
        Range range = Range.closeOpen(1, 3);
        assertTrue(range.constains(1));
    }
}
