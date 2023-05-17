package main;

public class PaidPlayer extends Player {


    public PaidPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Playing as a paid player");
        // game logic for paid players goes here
        incrementPlayCount();
    }


    public void accountInfo() {
        System.out.println("accountInfo...");
        // need to be implemented...
    }

}
