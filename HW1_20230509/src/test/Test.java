package test;

import main.FreePlayer;
import main.PaidPlayer;
import main.Player;

public class Test {

    //  upcasting is used to treat the child objects (FreePlayer and PaidPlayer)
    //  as parent objects (Player) so that they can be passed as arguments to the playTest() method,
    //  which accepts a Player parameter.
    //  This demonstrates the flexibility of upcasting,
    //  allowing us to use objects of the child classes wherever the parent class is expected.


//    Upcasting child class to Player
    public void playTest(Player player){
        player.play(); // Calls play() method of child class
    }

    public static void main(String[] args) {

        Test test = new Test();
        test.playTest(new FreePlayer("player_1"));// Upcasting FreePlayer to Player
        test.playTest(new PaidPlayer("player_2"));// Upcasting PaidPlayer to Player

    }

}
