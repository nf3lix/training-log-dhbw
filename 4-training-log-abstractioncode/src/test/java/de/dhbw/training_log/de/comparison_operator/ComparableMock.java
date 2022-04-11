package de.dhbw.training_log.de.comparison_operator;

public class ComparableMock implements Comparable<ComparableMock> {

    private final int value;


    public ComparableMock(final int value) {
        this.value = value;
    }

    @Override
    public int compareTo(ComparableMock o) {
        return this.value - o.value;
    }

}
