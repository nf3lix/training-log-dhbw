package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.plugins.CommandLine;
import de.dhbw.training_log.plugins.action.UserAction;

public class CompositeFilterAction implements UserAction {

    @Override
    public void initialize() {
        final String query = CommandLine.readLine();
    }

    @Override
    public String getDescription() {
        return "Filter";
    }

}
