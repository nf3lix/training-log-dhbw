package de.dhbw.training_log.plugins.action;

interface ActionObservable {

    void addExitMenuListener(ExitMenuListener listener);
    void notifyObserver();

}
