package dhbw.training_log.de.training_session_id;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import static dhbw.training_log.de.test_utils.ValueObjectTest.performValueObjectTest;

public class SessionIdTest {

    @Test
    public void valueObjectBehavior() {
        final List<Supplier<SessionId>> trainingSessionIds = Arrays.asList(
                () -> new SessionId(uuid("af2f909b-50cb-4fc5-aceb-c9fdc4699c27")),
                () -> new SessionId(uuid("e79b3ff0-530f-48d3-a8dd-e066fd2190fd")),
                () -> new SessionId(uuid("b206633a-0516-4d8b-844a-3e4b68557886")));
        performValueObjectTest(trainingSessionIds);
    }

    private UUID uuid(final String fromString) {
        return UUID.fromString(fromString);
    }

}
