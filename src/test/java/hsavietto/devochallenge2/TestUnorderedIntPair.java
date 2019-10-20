package hsavietto.devochallenge2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Helder Savietto (helder.savietto@gmail.com)
 */
public class TestUnorderedIntPair {

    @Test
    public void testUnordering() {
        UnorderedIntPair pair1 = new UnorderedIntPair(1, 2);
        UnorderedIntPair pair2 = new UnorderedIntPair(2, 1);

        Assert.assertEquals(pair1.getLesserValue(), pair2.getLesserValue());
        Assert.assertEquals(pair1.getGreaterValue(), pair2.getGreaterValue());
    }

    @Test
    public void testEquality() {
        UnorderedIntPair pair1 = new UnorderedIntPair(1, 2);
        UnorderedIntPair pair2 = new UnorderedIntPair(2, 1);
        UnorderedIntPair pair3 = new UnorderedIntPair(4, 5);
        UnorderedIntPair pair4 = new UnorderedIntPair(5, 4);

        Assert.assertEquals(pair1, pair2);
        Assert.assertEquals(pair3, pair4);
        Assert.assertEquals(pair2, pair1);
        Assert.assertEquals(pair4, pair3);

        Assert.assertNotEquals(pair1, pair3);
        Assert.assertNotEquals(pair1, pair4);
        Assert.assertNotEquals(pair2, pair3);
        Assert.assertNotEquals(pair2, pair4);
        Assert.assertNotEquals(pair3, pair1);
        Assert.assertNotEquals(pair4, pair1);
        Assert.assertNotEquals(pair3, pair2);
        Assert.assertNotEquals(pair4, pair2);
    }

    @Test
    public void testHashCode() {
        UnorderedIntPair pair1 = new UnorderedIntPair(1, 2);
        UnorderedIntPair pair2 = new UnorderedIntPair(2, 1);
        UnorderedIntPair pair3 = new UnorderedIntPair(4, 5);
        UnorderedIntPair pair4 = new UnorderedIntPair(5, 4);

        Assert.assertEquals(pair1.hashCode(), pair2.hashCode());
        Assert.assertEquals(pair3.hashCode(), pair4.hashCode());
        Assert.assertNotEquals(pair1.hashCode(), pair3.hashCode());
        Assert.assertNotEquals(pair1.hashCode(), pair4.hashCode());
        Assert.assertNotEquals(pair2.hashCode(), pair3.hashCode());
        Assert.assertNotEquals(pair2.hashCode(), pair4.hashCode());
    }

}
