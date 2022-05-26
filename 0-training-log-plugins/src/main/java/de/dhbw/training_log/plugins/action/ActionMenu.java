package de.dhbw.training_log.plugins.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class ActionMenu implements ActionObservable {

    private final Map<String, UserAction> useCases = new HashMap<>();
    private final Map<String, ActionMenu> nestedMenus = new HashMap<>();
    private final String description;
    private final InputReader inputReader;

    private Set<ExitMenuListener> observers = new HashSet<>();

    private final static String FIRST_SEPARATOR = "========= Type \"exit\" to close menu =========";
    private final static String SECOND_SEPARATOR =             "===============================================";

    public ActionMenu(final InputReader inputReader, final String description) {
        this.inputReader = inputReader;
        this.description = description;
    }

    public void addUseCase(final String mnemonic, final UserAction useCase) {
        this.useCases.put(mnemonic, useCase);
    }

    public void addNestedMenu(final String mnemonic, final ActionMenu menu) {
        this.nestedMenus.put(mnemonic, menu);
    }

    private UserAction getUseCase(final String mnemonic) {
        return this.useCases.get(mnemonic);
    }

    private ActionMenu getNestedMenu(final String mnemonic) {
        return this.nestedMenus.get(mnemonic);
    }

    private void printUseCases() {
        System.out.println(FIRST_SEPARATOR);
        this.useCases.forEach((mnemonic, useCase) -> System.out.println(mnemonic + ": " + useCase.getDescription()));
        this.nestedMenus.forEach((mnemonic, menu) -> System.out.println(mnemonic + ": " + menu.description));
        System.out.println(SECOND_SEPARATOR);
    }

    public void start() {
        do {
            printUseCases();
            final String mnemonic = inputReader.readCommandLine();
            if(mnemonic.equalsIgnoreCase("exit")) {
                notifyObserver();
                break;
            }
            UserAction selectedUseCase = getUseCase(mnemonic);
            ActionMenu selectedNestedMenu = getNestedMenu(mnemonic);
            if(selectedNestedMenu != null) {
                selectedNestedMenu.start();
                break;
            } else {
                selectedUseCase.initialize();
            }
        } while (true);
    }

    @Override
    public void addExitMenuListener(ExitMenuListener observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for(ExitMenuListener observer : observers) {
            observer.onExit();
        }
    }

}
