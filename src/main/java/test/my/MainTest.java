package test.my;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void testFindUnsortedSubarray1() {
        Assert.assertArrayEquals(new int[]{3, 5}, Main.findUnsortedSubarray(new int[]{1, 2, 3, 101, 4, 5}));
    }

    @Test
    public void testFindUnsortedSubarray2() {
        Assert.assertArrayEquals(new int[]{1, 4}, Main.findUnsortedSubarray(new int[]{1, 4, 3, 2, 3, 4}));
    }

    @Test
    public void testFindUnsortedSubarray3() {
        Assert.assertArrayEquals(new int[]{2, 6}, Main.findUnsortedSubarray(new int[]{15, 20, 30, 25, 40, 32, 35, 50}));
    }

    @Test
    public void testFindUnsortedSubarray4() {
        Assert.assertArrayEquals(new int[]{-1,-1}, Main.findUnsortedSubarray(new int[]{}));
    }

    @Test
    public void testFindUnsortedSubarray5() {
        Assert.assertArrayEquals(new int[]{-1,-1}, Main.findUnsortedSubarray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testFindUnsortedSubarray6() {
        Assert.assertArrayEquals(new int[]{0, 4}, Main.findUnsortedSubarray(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testFindUnsortedSubarray7() {
        Assert.assertArrayEquals(new int[]{0, 1}, Main.findUnsortedSubarray(new int[]{5, 4}));
    }

    @Test
    public void testFindUnsortedSubarray8() {
        Assert.assertArrayEquals(new int[]{0, 7}, Main.findUnsortedSubarray(new int[]{15, 20, 3, 2, 4, 21, 17, 18}));
    }

}