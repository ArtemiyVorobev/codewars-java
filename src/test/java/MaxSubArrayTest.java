import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSubArrayTest {
    @Test
    public void testEmptyArray() throws Exception {
        assertEquals("Empty arrays should have a max of 0", 0, MaxSubArray.sequence(new int[]{}));
    }
    @Test
    public void testExampleArray() throws Exception {
        assertEquals("Example array should have a max of 6", 6, MaxSubArray.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void testExampleArray2() throws Exception {
        assertEquals("Example array should have a max of 6", 6, MaxSubArray.sequence2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void testExampleArray3() throws Exception {
        assertEquals("Example array should have a max of 6", 2, MaxSubArray.sequence2(new int[]{-2, 4}));
    }
    @Test
    public void testExampleNegativeArray() throws Exception {
        assertEquals("Example array should have a max of 6", 0, MaxSubArray.sequence(new int[]{-2, -3, -1, -5}));
    }
}