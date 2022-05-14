package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.CommandLine;

import java.util.HashMap;
import java.util.Map;

public class UseCaseMenu {

    private final Map<String, UseCase> useCases = new HashMap<>();
    private final Map<String, UseCaseMenu> nestedMenus = new HashMap<>();
    private final SessionRepository repository;
    private final String description;
    private boolean isMainMenu = false;

    private final static String NESTED_MENU_SEPARATOR = "========= Type \"exit\" to go back to main menu =========";
    private final static String SEPARATOR = "=========================================================";

    public UseCaseMenu(final String description, final SessionRepository repository) {
        this.description = description;
        this.repository = repository;
    }

    public UseCaseMenu(final String description, final boolean isMainMenu, final SessionRepository repository) {
        this.description = description;
        this.isMainMenu = isMainMenu;
        this.repository = repository;
    }

    public void addUseCase(final String mnemonic, final UseCase useCase) {
        this.useCases.put(mnemonic, useCase);
    }

    public void addNestedMenu(final String mnemonic, final UseCaseMenu menu) {
        this.nestedMenus.put(mnemonic, menu);
    }

    private UseCase getUseCase(final String mnemonic) {
        return this.useCases.get(mnemonic);
    }

    private UseCaseMenu getNestedMenu(final String mnemonic) {
        return this.nestedMenus.get(mnemonic);
    }

    private void printUseCases() {
        if(isMainMenu) {
            System.out.println(SEPARATOR);
        } else {
            System.out.println(NESTED_MENU_SEPARATOR);
        }
        this.useCases.forEach((mnemonic, useCase) -> System.out.println(mnemonic + ") " + useCase.description()));
        this.nestedMenus.forEach((mnemonic, menu) -> System.out.println(mnemonic + ") " + menu.description));
        System.out.println(SEPARATOR);
    }

    public void start() {
        UseCase selectedUseCase;
        UseCaseMenu selectedNestedMenu;
        do {
            printUseCases();
            final String mnemonic = CommandLine.readLine();
            if(mnemonic.equalsIgnoreCase("exit")) {
                new MainMenu(repository).start();
                break;
            }
            selectedUseCase = getUseCase(mnemonic);
            selectedNestedMenu = getNestedMenu(mnemonic);
            if(selectedNestedMenu != null) {
                selectedNestedMenu.start();
            } else {
                selectedUseCase.initialize();
            }
        } while (selectedNestedMenu == null);
    }

}
