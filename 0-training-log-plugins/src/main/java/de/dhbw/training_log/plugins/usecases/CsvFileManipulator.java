package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.adapters.TrainingSessionResource;
import de.dhbw.training_log.adapters.TrainingSessionResourceMapper;
import dhbw.training_log.de.TrainingSession;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFileManipulator {

    private static final String PATH = "..\\training-log\\0-training-log-plugins\\src\\main\\resources\\sessions.csv";
    private static final String DELIMITER = ";";

    private final TrainingSessionResourceMapper resourceMapper = new TrainingSessionResourceMapper();

    List<TrainingSession> readCsv() throws IOException {
        final List<TrainingSession> sessions = new ArrayList<>();
        String line = "";
        final BufferedReader reader = new BufferedReader(new FileReader(PATH));
        while((line = reader.readLine()) != null) {
            sessions.add(sessionFromLine(line));
        }
        reader.close();
        return sessions;
    }

    void addSession(final TrainingSession trainingSession) throws IOException {
        final BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true));
        final String[] elements = resourceMapper.getResource(trainingSession).toCsvLine();
        final StringBuilder line = new StringBuilder();
        for(int i = 0; i < elements.length - 1; i++) {
            line.append(elements[i]).append(DELIMITER);
        }
        line.append(elements[elements.length - 1]);
        line.append("\n");
        writer.append(line);
        writer.close();
    }

    private TrainingSession sessionFromLine(final String line) {
        final String[] elements = line.split(DELIMITER);
        return resourceMapper.getEntity(TrainingSessionResource.fromCsvLine(elements));
    }

}
