package range;

/**
 * Clss Range to present a range of elements
 * 
 * @author QuangLeDinh
 *
 */
public class Range<T extends Comparable<T>> {
    
    // Indicates type of Range
    public enum TypeRange {OPEN,CLOSE,OPEN_CLOSE,CLOSE_OPEN};
    
    private final T lowerbound;
    private final T upperbound;
    private final TypeRange typeRange;

    /**
     * Create Range instance
     * 
     * @param lowerbound
     * @param upperbound
     * @param typeRange
     */
    public Range(T lowerbound, T upperbound, TypeRange typeRange) {
        if (lowerbound.compareTo(upperbound) > 0) {
            throw new IllegalArgumentException("wrong order, lowerbound > upperbound");
        }
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
        this.typeRange = typeRange;
    }
    
    /**
     * Check bigger value
     * 
     * @param start
     * @param end
     * @return true/false
     */
    public boolean isBigger(T start, T end) {
        return start.compareTo(end) > 0;
    }

    /**
     * Check smaller value
     * 
     * @param start
     * @param end
     * @return true/false
     */
    public boolean isSmaller(T start, T end) {
        return start.compareTo(end) < 0;
    }

    /**
     * 
     * @param <T>
     * @param min
     * @param max
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T extends Comparable<T>> Range of(T min, T max) {
        return new Range(min, max, TypeRange.CLOSE);
    }

    /**
     * Create a Range instance with type is Open
     * 
     * @param <T>
     * @param min
     * @param max
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T extends Comparable<T>> Range open(T min, T max) {
        return new Range(min, max, TypeRange.OPEN);
    }

    /**
     * Create a Range instance with type is Close
     * 
     * @param <T>
     * @param min
     * @param max
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T extends Comparable<T>> Range close(T min, T max) {
        return new Range(min, max, TypeRange.CLOSE);
    }
    
    /**
     * Create a Range instance with type is Open_Close
     * 
     * @param <T>
     * @param min
     * @param max
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T extends Comparable<T>> Range openClose(T min, T max) {
        return new Range(min, max, TypeRange.OPEN_CLOSE);
    }

    /**
     * Create a Range instance with type is Close_Open
     * 
     * @param <T>
     * @param min
     * @param max
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T extends Comparable<T>> Range closeOpen(T min, T max) {
        return new Range(min, max, TypeRange.CLOSE_OPEN);
    }

    /**
     * Check value contain inside Range
     * 
     * @param value
     * @return
     */
    public boolean contains(T value) {
        // Check contain by Range type
        switch (this.typeRange) {
        case OPEN:
            return (isBigger(value, this.lowerbound) && isSmaller(value, this.upperbound));
        case CLOSE:
            return (!isBigger(this.lowerbound, value) && !isBigger(value, this.upperbound));
        case OPEN_CLOSE:
            return (isBigger(value, this.lowerbound) && !isBigger(value, this.upperbound));
        case CLOSE_OPEN:
            return (!isBigger(this.lowerbound, value) && isBigger(this.upperbound, value));
        default:
            return false;
        }
    }
}
