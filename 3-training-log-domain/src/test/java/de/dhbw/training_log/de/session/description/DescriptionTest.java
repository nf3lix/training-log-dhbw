package de.dhbw.training_log.de.session.description;

import de.dhbw.training_log.de.test_utils.ValueObjectBehaviorTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DescriptionTest {

    @Test
    public void stringValue() {
        final Description description = new Description("TEST_DESCRIPTION");
        assertEquals(description.stringValue(), "TEST_DESCRIPTION");
    }

    @Test
    public void valueObjectBehavior() {
        final List<Supplier<Description>> descriptions = Arrays.asList(
                () -> new Description("DESCRIPTION_1"),
                () -> new Description("DESCRIPTION_2"),
                () -> new Description("DESCRIPTION_3"));
        ValueObjectBehaviorTest.withDisjointList(descriptions);
    }

}
