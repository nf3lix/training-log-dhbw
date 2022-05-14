package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.CommandLine;
import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;

public class FilterSessions extends UseCaseInitializer {

    @Override
    public void init(SessionRepository repository) {
        final FilterSessionsMenu menu = new FilterSessionsMenu(repository);
        menu.printUseCases();
        final String input = CommandLine.readLine();
        menu.initUseCase(input);
    }

}
