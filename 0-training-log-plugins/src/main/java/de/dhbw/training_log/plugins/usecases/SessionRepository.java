package de.dhbw.training_log.plugins.usecases;

import dhbw.training_log.de.TrainingSession;
import dhbw.training_log.de.TrainingSessionRepository;
import dhbw.training_log.de.training_session_id.TrainingSessionId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class SessionRepository implements TrainingSessionRepository {

    private final CsvFileManipulator reader = new CsvFileManipulator();

    private final List<TrainingSession> sessionsList = new ArrayList<>();

    public SessionRepository() {
        try {
            sessionsList.addAll(reader.readCsv());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public TrainingSessionId nextId() {
        return new TrainingSessionId(UUID.randomUUID());
    }

    @Override
    public Iterator<TrainingSession> getAll() {
        return sessionsList.listIterator();
    }

    @Override
    public void insert(final TrainingSession trainingSession) {
        sessionsList.add(trainingSession);
        try {
            reader.addSession(trainingSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
