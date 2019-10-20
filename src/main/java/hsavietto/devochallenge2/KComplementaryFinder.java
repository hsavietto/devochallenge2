package hsavietto.devochallenge2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Helder Savietto (helder.savietto@gmail.com)
 */
public class KComplementaryFinder {

    /**
     * @param k      the K value
     * @param values array of values
     * @return a list of pairs
     */
    public Set<UnorderedIntPair> findKComplementaries(long k, int[] values) {
        Set<UnorderedIntPair> complementaries = new HashSet<>();

        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] + values[j] == k) {
                    complementaries.add(new UnorderedIntPair(i, j));
                }
            }
        }

        return complementaries;
    }
}
