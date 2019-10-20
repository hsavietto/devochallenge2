package hsavietto.devochallenge2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * @author Helder Savietto (helder.savietto@gmail.com)
 */
public class TestKComplementaryFinder {

    @Test
    public void testNoComplementaryFound() {
        int[] values = new int[]{3, 1, 4, 2, 5};
        KComplementaryFinder kFinder = new KComplementaryFinder();
        Set<UnorderedIntPair> result = kFinder.findKComplementaries(15, values);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleComplementaryFound() {
        int[] values = new int[]{3, 1, 4, 2, 5};
        KComplementaryFinder kFinder = new KComplementaryFinder();
        Set<UnorderedIntPair> result = kFinder.findKComplementaries(9, values);
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(new UnorderedIntPair(2, 4)));
        Assert.assertTrue(result.contains(new UnorderedIntPair(4, 2)));
    }

    @Test
    public void testMultipleComplementaryFound() {
        int[] values = new int[]{3, 1, 4, 2, 5};
        KComplementaryFinder kFinder = new KComplementaryFinder();
        Set<UnorderedIntPair> result = kFinder.findKComplementaries(6, values);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(new UnorderedIntPair(1, 4)));
        Assert.assertTrue(result.contains(new UnorderedIntPair(2, 3)));
    }

    @Test
    public void testRepeatedValues() {
        int[] values = new int[]{3, 1, 4, 1, 3, 2, 5, 1, 5};
        KComplementaryFinder kFinder = new KComplementaryFinder();
        Set<UnorderedIntPair> result = kFinder.findKComplementaries(6, values);
        Assert.assertEquals(8, result.size());
        Assert.assertTrue(result.contains(new UnorderedIntPair(0, 4)));
        Assert.assertTrue(result.contains(new UnorderedIntPair(1, 6)));
        Assert.assertTrue(result.contains(new UnorderedIntPair(1, 8)));
        Assert.assertTrue(result.contains(new UnorderedIntPair(2, 5)));
        Assert.assertTrue(result.contains(new UnorderedIntPair(3, 6)));
        Assert.assertTrue(result.contains(new UnorderedIntPair(3, 8)));
        Assert.assertTrue(result.contains(new UnorderedIntPair(6, 7)));
        Assert.assertTrue(result.contains(new UnorderedIntPair(7, 8)));
    }

    @Test
    public void testWithBigArray() {
        int testSize = 500000;
        long setupStart = System.nanoTime();
        int[] values = new int[testSize];

        for (int i = 0; i < testSize; ++i) {
            values[i] = i;
        }

        long elapsedSetup = System.nanoTime() - setupStart;
        long runStart = System.nanoTime();
        int testK = testSize * 2 - 3; // just the last two indexes as result
        KComplementaryFinder kFinder = new KComplementaryFinder();
        Set<UnorderedIntPair> result = kFinder.findKComplementaries(testK, values);
        long elapsedRun = System.nanoTime() - runStart;
        long runSetupRatio = elapsedRun / elapsedSetup;
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(new UnorderedIntPair(testSize - 2, testSize - 1)));
        Assert.assertTrue(runSetupRatio < 75);
    }
}
