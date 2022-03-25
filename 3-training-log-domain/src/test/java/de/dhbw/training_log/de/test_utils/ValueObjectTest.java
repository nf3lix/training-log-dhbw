package de.dhbw.training_log.de.test_utils;

import java.util.*;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class ValueObjectTest<T> {

    private final List<ClassContainer<T>> containers = new ArrayList<>();

    /**
     * <p>Performs tests for common Value Object behaviors including
     *  <ul>
     *      <li>equality/inequality</li>
     *      <li>instance equality/inequality</li>
     *      <li>hash code equality/inequality</li>
     *  </ul>
     * </p>
     * @param suppliers list of suppliers defining disjoint list of objects
     * @param <T> Value Object to test
     */
    public static <T> void performValueObjectTest(final List<Supplier<T>> suppliers) {
        final ValueObjectTest<T> test = new ValueObjectTest<>(suppliers);
        test.performTests();
    }

    public ValueObjectTest(final List<Supplier<T>> objects) {
        for(Supplier<T> supplier : objects) {
            containers.add(new ClassContainer<>(supplier));
        }
        expectDisjointList();
        expectMinSize();
    }

    public void performTests() {
        testValueEquality();
        testInstanceEquality();
        testValueInequality();
        testHashcodeEquality();
        testHashcodeInequality();
    }

    private void testValueEquality() {
        for(ClassContainer<T> container : containers) {
            assertEquals(container.createContents(), container.createContents());
        }
    }

    private void testInstanceEquality() {
        for(ClassContainer<T> container : containers) {
            final T object = container.createContents();
            assertEquals(object, object);
        }
    }

    private void testValueInequality() {
        for(ClassContainer<T> container : containers) {
            final Set<ClassContainer<T>> containerSet = new HashSet<>(containers);
            compareInequalityWithAll(container, containerSet);
        }
    }

    private void testHashcodeEquality() {
        for(ClassContainer<T> container : containers) {
            assertEquals(container.createContents().hashCode(), container.createContents().hashCode());
        }
    }

    private void testHashcodeInequality() {
        for(ClassContainer<T> container : containers) {
            final Set<ClassContainer<T>> containerSet = new HashSet<>(containers);
            compareHashCodeInEqualityWithAll(container, containerSet);
        }
    }

    private void compareInequalityWithAll(ClassContainer<T> container, final Set<ClassContainer<T>> containerSet) {
        for(ClassContainer<T> comparedContainer : containerSet) {
            if(container != comparedContainer) {
                assertInequality(container.createContents(), comparedContainer.createContents());
            }
        }
    }

    private void compareHashCodeInEqualityWithAll(ClassContainer<T> container, final Set<ClassContainer<T>> containerSet) {
        for(ClassContainer<T> comparedContainer : containerSet) {
            if(container != comparedContainer) {
                assertNotEquals(container.createContents().hashCode(), comparedContainer.createContents().hashCode());
            }
        }
    }

    private void assertInequality(T object1, T object2) {
        assertNotEquals(object1, object2);
        assertNotEquals(object1, new Object());
        assertNotEquals(object1, null);
    }

    private void expectDisjointList() {
        final Set<T> set = new HashSet<>();
        for(ClassContainer<T> container : containers) {
            set.add(container.createContents());
        }
        if(set.size() != containers.size()) {
            throw new IllegalStateException("Supplied objects should be different from each other");
        }
    }

    private void expectMinSize() {
        if(containers.size() < 2) {
            throw new IllegalStateException("At least two different objects should be supplied");
        }
    }

}
