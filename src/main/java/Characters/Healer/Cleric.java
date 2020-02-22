package Players.Healer;

import Players.Character;

public class Cleric extends Healer {

    public Cleric(String name, int healthPoints) {
        super(name, healthPoints);
    }

    public void healPlayer(Character character){
        character.beHealed(getHealingItem().getHealingPower());
    }
}
