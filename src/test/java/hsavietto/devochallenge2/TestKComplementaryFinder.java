package hsavietto.devochallenge2;

import javafx.util.Pair;
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
        Set<Pair<Integer, Integer>> result = kFinder.findKComplementaries(15, values);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleComplementaryFound() {
        int[] values = new int[]{3, 1, 4, 2, 5};
        KComplementaryFinder kFinder = new KComplementaryFinder();
        Set<Pair<Integer, Integer>> result = kFinder.findKComplementaries(9, values);
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(new Pair<>(2, 4)));
    }

    @Test
    public void testMultipleComplementaryFound() {
        int[] values = new int[]{3, 1, 4, 2, 5};
        KComplementaryFinder kFinder = new KComplementaryFinder();
        Set<Pair<Integer, Integer>> result = kFinder.findKComplementaries(6, values);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(new Pair<>(1, 4)));
        Assert.assertTrue(result.contains(new Pair<>(2, 3)));
    }
}
