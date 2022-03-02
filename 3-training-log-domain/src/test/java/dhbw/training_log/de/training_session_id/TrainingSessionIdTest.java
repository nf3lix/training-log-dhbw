package dhbw.training_log.de.training_session_id;

import dhbw.training_log.de.training_session_id.TrainingSessionId;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import static dhbw.training_log.de.test_utils.ValueObjectTest.performValueObjectTest;

public class TrainingSessionIdTest {

    @Test
    public void valueObjectBehavior() {
        final List<Supplier<TrainingSessionId>> trainingSessionIds = Arrays.asList(
                () -> new TrainingSessionId(uuid("af2f909b-50cb-4fc5-aceb-c9fdc4699c27")),
                () -> new TrainingSessionId(uuid("e79b3ff0-530f-48d3-a8dd-e066fd2190fd")),
                () -> new TrainingSessionId(uuid("b206633a-0516-4d8b-844a-3e4b68557886")));
        performValueObjectTest(trainingSessionIds);
    }

    private UUID uuid(final String fromString) {
        return UUID.fromString(fromString);
    }

}
