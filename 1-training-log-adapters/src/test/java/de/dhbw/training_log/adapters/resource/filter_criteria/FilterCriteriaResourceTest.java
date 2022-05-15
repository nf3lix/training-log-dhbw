package de.dhbw.training_log.adapters.resource.filter_criteria;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilterCriteriaResourceTest {

    private static class FilterCriteriaResourceFake extends FilterCriteriaResource<String> {
        public FilterCriteriaResourceFake(final String input) {
            super(input);
        }

        @Override
        public String parseStringValue(String input) {
            return input;
        }
    }

    @Test
    public void readLongestMatchingComparisonOperator() {
        final FilterCriteriaResourceFake criteria1 = new FilterCriteriaResourceFake(">=TEST");
        final FilterCriteriaResourceFake criteria2 = new FilterCriteriaResourceFake("<=TEST");
        Assertions.assertEquals(criteria1.getComparisonOperator(), ComparisonOperator.GREATER_OR_EQUAL);
        Assertions.assertEquals(criteria2.getComparisonOperator(), ComparisonOperator.LESS_OR_EQUAL);
    }

}
