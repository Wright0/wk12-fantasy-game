package Characters.Healer;
import Items.HealingItems.HealingItem;
import Characters.Character;

public abstract class Healer extends Character {

    private HealingItem healingitem;

    public Healer(String name, int healthPoints) {
        super(name, healthPoints);
        this.healingitem = null;
        this.battleOption = "heal";
    }

    public void receiveNewHealingItem(HealingItem newItem){
        this.healingitem = newItem;
    }

    public HealingItem getHealingItem(){
        return this.healingitem;
    }

    public void heal(Character character){
        character.beHealed(getHealingItem().getHealingPower());
    }

    public int battleAction(String action, Character target) {
        if (action.equals("heal")) {
            this.heal(target);
            return this.healingitem.getHealingPower();
        } return 0;
    }

}
