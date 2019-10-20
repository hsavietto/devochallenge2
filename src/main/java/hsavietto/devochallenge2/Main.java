package hsavietto.devochallenge2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

/**
 * @author Helder Savietto (helder.savietto@gmail.com)
 */
public class Main {

    private static int[] convertInputToValues(String input) {
        String[] strValues = input.trim().split("\\s+");
        int[] values = new int[strValues.length];

        for(int i = 0; i < strValues.length; ++i) {
            values[i] = Integer.parseInt(strValues[i]);
        }

        return values;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the list of values (integer numbers separated by spaces): ");
        String input = reader.readLine();
        int[] values = convertInputToValues(input);
        System.out.print("Enter with a value for K: ");
        String strK = reader.readLine();
        int k = Integer.parseInt(strK);
        KComplementaryFinder finder = new KComplementaryFinder();
        Set<UnorderedIntPair> pairs = finder.findKComplementaries(k, values);

        if(pairs.isEmpty()) {
            System.out.println("No K-complementary pairs found");
        } else {
            System.out.println("Found " + pairs.size() + " K-complementary pairs:");

            for(UnorderedIntPair pair: pairs) {
                System.out.println("(" + pair.getLesserValue() + "," + pair.getGreaterValue() + ")");
            }
        }
    }

}
