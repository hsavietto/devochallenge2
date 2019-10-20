package hsavietto.devochallenge2;

import java.util.*;

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

        if (k > (long) Integer.MAX_VALUE * 2) {
            return complementaries;
        }

        Map<Integer, List<Integer>> complementaryPositions = new HashMap<>();

        for (int i = 0; i < values.length; ++i) {
            int complementary = (int) (k - values[i]);
            complementaryPositions.merge(complementary, Collections.singletonList(i), (l, v) -> {
                ArrayList<Integer> newList = new ArrayList<>(l);
                newList.addAll(v);
                return newList;
            });
        }

        for (int i = 0; i < values.length; ++i) {
            List<Integer> indexes = complementaryPositions.get(values[i]);

            if (indexes != null) {
                for (int complementaryPosition : indexes) {
                    if (complementaryPosition != i) {
                        complementaries.add(new UnorderedIntPair(i, complementaryPosition));
                    }
                }
            }
        }

        return complementaries;
    }
}
