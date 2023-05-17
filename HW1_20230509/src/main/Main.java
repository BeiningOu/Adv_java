package main;

public class Main {
    public static void main(String[] args) {
        PaidPlayer player1 = new PaidPlayer("Tom");
        FreePlayer player2 = new FreePlayer("Sam");
        // if we upcasting it will not carry child's own methods like accountInfo() and upgrade()

        for (int i = 0; i < 4; i++) {
            // play game 4 time just to see the difference of free/paid player
            playGame(player1);
            playGame(player2);
        }

        player1.accountInfo(); // need to be implemented...
        player2.upgrade();  // need to be implemented...

        GameController gameController = new GameController(player1);
        gameController.startGame();

    }

    public static void playGame(Player player) {
        player.play();
    }
}

