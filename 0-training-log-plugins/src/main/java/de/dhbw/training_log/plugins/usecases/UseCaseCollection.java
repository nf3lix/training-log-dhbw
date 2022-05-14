package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.usecases.create_session.CreateSession;
import de.dhbw.training_log.plugins.usecases.filter_sessions.FilterSessions;
import de.dhbw.training_log.plugins.usecases.generate_report.GenerateReport;
import de.dhbw.training_log.plugins.usecases.read_session.ReadSession;

import java.util.Optional;

import static java.util.Arrays.stream;

public enum UseCaseCollection {

    CREATE_SESSION("1","Create new training session", new CreateSession()),
    READ_SESSION("2", "Show all training sessions", new ReadSession()),
    GENERATE_REPORT("3", "Generate Report", new GenerateReport()),
    FILTER_SESSIONS("4", "Filter Sessions", new FilterSessions());

    private final String mnemonic;
    private final String useCaseDescription;
    private final UseCaseInitializer initializer;

    UseCaseCollection(final String mnemonic, final String useCaseDescription, final UseCaseInitializer initializer) {
        this.mnemonic = mnemonic;
        this.useCaseDescription = useCaseDescription;
        this.initializer = initializer;
    }

    public String mnemonic() {
        return mnemonic;
    }

    public String description() {
        return useCaseDescription;
    }

    public void initialize(SessionRepository repository) {
        initializer.init(repository);
    }

    public static UseCaseCollection fromMnemonic(final String mnemonic) throws IllegalArgumentException {
        final Optional<UseCaseCollection> useCase = stream(values()).filter(uc -> uc.mnemonic.equals(mnemonic)).findFirst();
        if(!useCase.isPresent()) {
            throw new IllegalArgumentException("There's no use case for this mnemonic");
        }
        return useCase.get();
    }

}
