package de.dhbw.training_log.plugins.persistence;

import dhbw.training_log.de.Session;
import dhbw.training_log.de.training_session_id.SessionId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class SessionRepositoryImpl implements dhbw.training_log.de.SessionRepository {

    private final FileManipulator fileManipulator;
    private final List<Session> sessionsList = new ArrayList<>();

    public SessionRepositoryImpl(final FileManipulator fileManipulator) {
        this.fileManipulator = fileManipulator;
        try {
            sessionsList.addAll(this.fileManipulator.readSessions());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SessionId nextId() {
        return new SessionId(UUID.randomUUID());
    }

    @Override
    public Iterator<Session> getAll() {
        return sessionsList.listIterator();
    }

    @Override
    public void insert(final Session session) {
        sessionsList.add(session);
        try {
            fileManipulator.addSession(session);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
