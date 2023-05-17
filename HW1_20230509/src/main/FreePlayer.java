package main;

public class FreePlayer extends Player {
    private static final int MAX_PLAY_COUNT = 3;


    public FreePlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        if (getPlayCount() < MAX_PLAY_COUNT) {
            System.out.println("Playing as a free player...");
            // the game play here...
            incrementPlayCount();
        } else {
            System.out.println("You have reached the maximum number of plays as a free player.");
        }
    }

    public void upgrade() {
        System.out.println("upgrading...");
        // need to be implemented...
    }


}
