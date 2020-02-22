package Characters.Healer;
import Items.HealingItems.HealingItem;
import Characters.Character;

public abstract class Healer extends Character {

    private HealingItem healingitem;

    public Healer(String name, int healthPoints) {
        super(name, healthPoints);
        this.healingitem = null;
    }

    public void receiveNewHealingItem(HealingItem newItem){
        this.healingitem = newItem;
    }

    public HealingItem getHealingItem(){
        return this.healingitem;
    }

    public abstract void healPlayer(Character character);

}
