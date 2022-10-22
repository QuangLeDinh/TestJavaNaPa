/*
 * Author: LeDinhQuang
 */
package range;

public class Range {
    private final int lowerbound;
    private final int upperbound;

    public Range(int lowerbound, int upperbound) {
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
    }

    public static Range of(int min, int max) {
        return (min > max) ? null : new Range(min, max);
    }

    public static Range open(int min, int max) {
        return (min > max) ? null : new Range(min++, max--);
    }

    public static Range close(int min, int max) {
        return (min > max) ? null : new Range(min, max);
    }

    public static Range openClose(int min, int max) {
        return (min > max) ? null : new Range(min++, max);
    }

    public static Range closeOpen(int min, int max) {
        return (min > max) ? null : new Range(min, max++);
    }

    public boolean constains(int num) {
        return (num >= this.lowerbound) && (num <= this.upperbound);
    }
}
