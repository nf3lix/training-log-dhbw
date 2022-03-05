package de.dhbw.training_log.plugins.usecases;

import java.util.Scanner;

public class CommandLine {

    static String readLine() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
