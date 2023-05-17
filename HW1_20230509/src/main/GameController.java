package main;


import java.util.List;

public class GameController {
    private Player player;
    private DialogueGenerator dialogueGenerator;

    public GameController(Player player) {
        this.player = player;
        this.dialogueGenerator = new DialogueGenerator();
    }

    public void startGame() {
        System.out.println("Welcome to the game!");

        while (!dialogueGenerator.isGameEnd()) {
            String currentDialogue = dialogueGenerator.getNextDialogue();
            System.out.println(currentDialogue);

            String playerChoice = getPlayerChoice();
            dialogueGenerator.processPlayerChoice(playerChoice);
        }

        System.out.println("Game Over!");
    }

    private String getPlayerChoice() {
        // Retrieve player input from user
        // You can use the appropriate Java code to read user input here
        // For simplicity, let's assume the choice is entered as "yes" or "no"

        String choice = "yes"; // Assuming player enters a valid choice

        return choice;
    }
}

