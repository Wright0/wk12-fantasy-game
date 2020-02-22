package Players.Healer;

import Players.Player;

public class Cleric extends Healer {

    public Cleric(String name, int healthPoints) {
        super(name, healthPoints);
    }

    public void healPlayer(Player player){
        player.beHealed(getHealingItem().getHealingPower());
    }
}
