package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.de.session.SessionRepository;

public interface UserAction {
    void initialize();
    String getDescription();
}
