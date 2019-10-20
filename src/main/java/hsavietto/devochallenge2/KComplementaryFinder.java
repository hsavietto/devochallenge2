package hsavietto.devochallenge2;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Helder Savietto (helder.savietto@gmail.com)
 */
public class KComplementaryFinder {

    /**
     * @param k the K value
     * @param values array of values
     * @return a list of pairs
     */
    public Set<Pair<Integer, Integer>> findKComplementaries(long k, int[] values) {
        Set<Pair<Integer, Integer>> complementaries = new HashSet<>();

        for(int i = 0; i < values.length - 1; i++) {
            for(int j = i + 1; j < values.length; j++) {
                if(values[i] + values[j] == k) {
                    complementaries.add(new Pair<>(i, j));
                }
            }
        }

        return complementaries;
    }
}
