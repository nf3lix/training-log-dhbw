package de.dhbw.training_log.plugins.action;

import java.util.Scanner;

public class CommandLineReader implements InputReader {

    @Override
    public String readCommandLine() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
