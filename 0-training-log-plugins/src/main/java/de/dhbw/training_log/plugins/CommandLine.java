package de.dhbw.training_log.plugins;

import java.util.Scanner;

public class CommandLine {

    public static String readLine() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
