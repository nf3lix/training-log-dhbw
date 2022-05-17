package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.de.session.SessionRepository;

public interface UseCase {
    void initialize();
    String getDescription();

}
