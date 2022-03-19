package de.dhbw.training_log.plugins.persistence;

import de.dhbw.training_log.de.Session;

import java.io.IOException;
import java.util.List;

public interface FileManipulator {
    List<Session> readSessions() throws IOException;
    void addSession(final Session session) throws IOException;
}
