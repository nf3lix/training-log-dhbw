package de.dhbw.training_log.de.test_utils.test;

import de.dhbw.training_log.de.test_utils.ValueObjectBehaviorTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ValueObjectBehaviorTest_Test {

    @Test
    public void throwExceptionWhenSuppliedListHasLessThan2Objects() {
        final List<Supplier<Integer>> list = new ArrayList<>();
        list.add(() -> 1);
        Assertions.assertThrows(IllegalStateException.class, () -> new ValueObjectBehaviorTest.Builder<Integer>()
            .setDisjointList(list).build());
    }

    @Test
    public void throwExceptionWhenSuppliedListIsNotDisjoint() {
        final List<Supplier<Integer>> list = new ArrayList<>();
        list.add(() -> 1);
        list.add(() -> 1);
        Assertions.assertThrows(IllegalStateException.class, () -> new ValueObjectBehaviorTest.Builder<Integer>()
                .setDisjointList(list).build());
    }

}
