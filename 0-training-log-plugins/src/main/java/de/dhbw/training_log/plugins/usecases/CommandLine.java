package de.dhbw.training_log.plugins.usecases;

public class CommandLine {

    static String readLine() {
        final java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextLine();
    }

}
