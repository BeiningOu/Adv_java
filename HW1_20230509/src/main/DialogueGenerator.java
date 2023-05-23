package main;

import java.util.ArrayList;
import java.util.List;



public class DialogueGenerator {

    public String lastQ;



    public DialogueGenerator() {
        lastQ = "";
//        dialogueList = new ArrayList<>();
//        dialogueList.add("Dialogue 1? (yes/no)");
//        dialogueList.add("Dialogue 2? (yes/no)");
//        dialogueList.add("Dialogue 3? (yes/no)");
        // Add more dialogues as per your game's requirement

//        currentDialogueIndex = 0;
    }

    public String getNextDialogue(String input, int currentDialogueIndex) {

        if (currentDialogueIndex >= 0 && currentDialogueIndex < 20) {

            System.out.println("currentDialogueIndex " +  currentDialogueIndex);

            lastQ = ChatGPTap.prompts(input, lastQ);

            return lastQ;
        }
        if (currentDialogueIndex == 20) {
            return ChatGPTapi.lastprompts(input);
        }

    }

    public void processPlayerChoice(String choice) {
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Player chose 'yes'");
            // Process 'yes' choice as per your game's logic
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("Player chose 'no'");
            // Process 'no' choice as per your game's logic
        } else {
            System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
            // Handle invalid choice
        }

//        currentDialogueIndex++;
    }

//    public boolean isGameEnd() {
////        return currentDialogueIndex >= dialogueList.size();
//    }


//    public static void main(String[] args) {
//        getNextDialogue();
//    }


}
