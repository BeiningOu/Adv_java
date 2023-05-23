package main;

public abstract class Player {


//    implement the player class here with the player as an abstract class,
//    two child classes 'paid player' and 'free player',
//    where paid play can play unlimited time and free play only got three plays.
    private String name;
    protected int playCount;

    public Player(String name) {
        this.playCount = 0;
        this.name = name;
    }

    public abstract void play();

    public void incrementPlayCount() {
        playCount++;
    }

    public int getPlayCount() {
        return playCount;
    }
}

