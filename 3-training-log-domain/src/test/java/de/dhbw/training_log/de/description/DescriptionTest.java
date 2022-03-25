package de.dhbw.training_log.de.description;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static de.dhbw.training_log.de.test_utils.ValueObjectTest.performValueObjectTest;

public class DescriptionTest {

    @Test
    public void valueObjectBehavior() {
        final List<Supplier<Description>> descriptions = Arrays.asList(
                () -> new Description("DESCRIPTION_1"),
                () -> new Description("DESCRIPTION_2"),
                () -> new Description("DESCRIPTION_3"));
        performValueObjectTest(descriptions);
    }

}
