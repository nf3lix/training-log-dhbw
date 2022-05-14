package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.CommandLine;
import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;

import java.util.Optional;

import static java.util.Arrays.stream;

public class FilterSessions extends UseCaseInitializer {

    private enum FilterSessionsUseCase {

        FILTER_SESSIONS_BY_DISTANCE("1", "Filter sessions by distance", new FilterSessionsByDistance()),
        FILTER_SESSIONS_BY_TIME("2", "Filter sessions by time", new FilterSessionsBySessionTime()),
        FILTER_SESSIONS_BY_DATE("3", "Filter sessions by date", new FilterSessionsByDate());

        private final String mnemonic;
        private final String useCaseDescription;
        private final UseCaseInitializer initializer;

        FilterSessionsUseCase(final String mnemonic, final String useCaseDescription, final UseCaseInitializer initializer) {
            this.mnemonic = mnemonic;
            this.useCaseDescription = useCaseDescription;
            this.initializer = initializer;
        }

        public void initialize(SessionRepository repository) {
            initializer.init(repository);
        }

        public String mnemonic() {
            return mnemonic;
        }

        public String description() {
            return useCaseDescription;
        }

    }

    public static FilterSessionsUseCase fromMnemonic(final String mnemonic) throws IllegalArgumentException {
        final Optional<FilterSessionsUseCase> useCase = stream(FilterSessionsUseCase.values()).filter(uc -> uc.mnemonic.equals(mnemonic)).findFirst();
        if(!useCase.isPresent()) {
            throw new IllegalArgumentException("There's no use case for this mnemonic");
        }
        return useCase.get();
    }

    @Override
    public void init(SessionRepository repository) {
        printUseCases();
        final String input = CommandLine.readLine();
        fromMnemonic(input).initialize(repository);
    }

    private static void printUseCases() {
        for(final FilterSessionsUseCase useCase : FilterSessionsUseCase.values()) {
            System.out.println(useCase.mnemonic() + ") " + useCase.description());
        }
    }

}
