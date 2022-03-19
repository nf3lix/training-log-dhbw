package de.dhbw.training_log.plugins.usecases;

import dhbw.training_log.de.Session;
import dhbw.training_log.de.training_session_id.SessionId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class SessionRepository implements dhbw.training_log.de.SessionRepository {

    private final CsvFileManipulator reader = new CsvFileManipulator();

    private final List<Session> sessionsList = new ArrayList<>();

    public SessionRepository() {
        try {
            sessionsList.addAll(reader.readCsv());
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
    public void insert(final Session trainingSession) {
        sessionsList.add(trainingSession);
        try {
            reader.addSession(trainingSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
