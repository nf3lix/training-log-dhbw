package dhbw.training_log.de.training_session_id;

import java.util.Objects;
import java.util.UUID;

public final class TrainingSessionId {

    private final UUID uuid;

    public TrainingSessionId(final UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingSessionId that = (TrainingSessionId) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

}
