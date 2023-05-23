package main;


import java.util.List;

import java.util.Scanner;

public class GameController {

    private Player player;
    private static DialogueGenerator dialogueGenerator;
    private int currentDialogueIndex;

    private Scanner scanner;

    private String userInput;

    public GameController() {
//        this.player = player;
        scanner = new Scanner(System.in);
        userInput = "";
    }

    public void startGame() {
        dialogueGenerator = new DialogueGenerator();
        currentDialogueIndex = 0;
        System.out.println("Welcome to the game!");

        while (currentDialogueIndex < 20) {

            String dialogue = dialogueGenerator.getNextDialogue(userInput, currentDialogueIndex);
            System.out.println(dialogue);

            userInput = getUserInput(); // Implement a method to get user input

            currentDialogueIndex++;
        }
    }

//    private String getPlayerChoice() {
//        // Retrieve player input from user
//        // You can use the appropriate Java code to read user input here
//        // For simplicity, let's assume the choice is entered as "yes" or "no"
//
//        String choice = "yes"; // Assuming player enters a valid choice
//
//        return choice;
//    }

    private String getUserInput() {
        System.out.print("Enter your choice 1 or 2: ");
        userInput = scanner.nextLine();

        // Validate user input
        while (!userInput.equals("1") && !userInput.equals("2")) {
            System.out.println("Invalid input. Please enter 1 or 2.");
            System.out.print("Enter your choice (1 or 2): ");
            userInput = scanner.nextLine();

        }

        System.out.print("You chose "+ userInput);
        return userInput;
    }

        public static void main(String[] args) {

            GameController g = new GameController();
            g.getUserInput();
    }



}

