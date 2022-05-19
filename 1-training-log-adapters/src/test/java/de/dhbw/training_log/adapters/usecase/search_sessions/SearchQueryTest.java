package de.dhbw.training_log.adapters.usecase.search_sessions;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchQueryTest {

    @Test
    public void parseFieldName() {
        final String input1 = "A>VALUE";
        final String input2 = "ABC>VALUE";
        final String input3 = "ABCDEFG>VALUE";
        assertEquals(new SearchQuery(input1).getFieldName(), "A");
        assertEquals(new SearchQuery(input2).getFieldName(), "ABC");
        assertEquals(new SearchQuery(input3).getFieldName(), "ABCDEFG");
    }

    @Test
    public void parseComparisonOperator() {
        for(ComparisonOperator comparisonOperator : ComparisonOperator.values()) {
            assertEquals(new SearchQuery("A" + comparisonOperator.stringRepresentation() + "VALUE").getComparisonOperator(), comparisonOperator);
            assertEquals(new SearchQuery("ABC" + comparisonOperator.stringRepresentation() + "VALUE").getComparisonOperator(), comparisonOperator);
            assertEquals(new SearchQuery("ABCDEFG" + comparisonOperator.stringRepresentation() + "VALUE").getComparisonOperator(), comparisonOperator);
        }
    }

    @Test
    public void parseComparedValue() {
        final String input1 = "ABC>VALUE1";
        final String input2 = "ABC>=VALUE2";
        final String input3 = "ABCDEFG>VALUE3";
        final String input4 = "ABCDEFG>=VALUE4";
        assertEquals(new SearchQuery(input1).getComparedValue(), "VALUE1");
        assertEquals(new SearchQuery(input2).getComparedValue(), "VALUE2");
        assertEquals(new SearchQuery(input3).getComparedValue(), "VALUE3");
        assertEquals(new SearchQuery(input4).getComparedValue(), "VALUE4");
    }

}
