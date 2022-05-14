package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.application.Service;

public class UseCase {

    private final String description;
    private final Service service;

    public UseCase(final String description, final Service service) {
        this.description = description;
        this.service = service;
    }

    public String description() {
        return description;
    }

    public void initialize() {
        service.run();
    }

}
