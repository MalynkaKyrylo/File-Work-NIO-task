package app;

import app.service.FileReadService;
import app.service.FileWriteService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        handleChoice(getChoice());
    }

    private static int getChoice() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select the file processing option:\n" +
                    "1) Create and write in file\n" +
                    "2) Read file\n" +
                    "0) Close the app");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Not a number input!");
            return getChoice();
        }
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                getOutput(writeFile(getFileName(), getWriteData()));
                break;
            case 2:
                getOutput(readFile(getReadData()));
                break;
            case 0:
                System.out.println("App closed");
                System.exit(0);
            default:
                System.out.println("Wrong value " + choice);
                handleChoice(choice);
        }
    }

    private static String getWriteData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        return scanner.nextLine();
    }

    private static String getFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name: ");
        return scanner.nextLine();
    }

    private static String getReadData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name to show it's content: ");
        return scanner.nextLine();
    }

    private static String readFile(String file) {
        return new FileReadService().readFromFile(file);
    }

    private static String writeFile(String file, String message) {
        return new FileWriteService().writeToFile(file, message);
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
