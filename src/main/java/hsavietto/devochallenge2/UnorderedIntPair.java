package hsavietto.devochallenge2;

/**
 * An unordered pair of integer values.
 *
 * @author Helder Savietto (helder.savietto@gmail.com)
 */
public class UnorderedIntPair {

    private final int lesserValue;
    private final int greaterValue;

    /**
     * Constructor
     *
     * @param firstValue  one of the values
     * @param secondValue the other value
     */
    public UnorderedIntPair(int firstValue, int secondValue) {
        this.lesserValue = Math.min(firstValue, secondValue);
        this.greaterValue = Math.max(firstValue, secondValue);
    }

    /**
     * lesser value accessor
     *
     * @return the lesser value
     */
    public int getLesserValue() {
        return lesserValue;
    }

    /**
     * greater value accessor
     *
     * @return the greater value
     */
    public int getGreaterValue() {
        return greaterValue;
    }

    @Override
    public int hashCode() {
        // using an arbitrary "big" prime number to avoid collisions up to 10,000 and reducing it above this threshold
        return lesserValue * 10007 + greaterValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UnorderedIntPair that = (UnorderedIntPair) o;
        return lesserValue == that.lesserValue && greaterValue == that.greaterValue;
    }
}
