package Characters.MeleeFighter;

import Items.Weapons.Weapon;
import Characters.Character;

public abstract class MeleeFighter extends Character {
    protected Weapon weapon;


    public MeleeFighter(String name, int healthPoints) {
        super(name, healthPoints);
        weapon = null;
        this.battleOption = "attack";
    }

    public void receiveNewWeapon(Weapon newItem){
        this.weapon = newItem;
    }

    public void attack(Character character){
        character.takeHealthDamage(this.weapon.getAttackPower());
    }

    public int battleAction(String action, Character target){
        if (action.equals("attack")){
            this.attack(target);
            return this.weapon.getAttackPower();
        } return 0;
    }
    //There has to be a better way to do this. Returning the value of the
    // action feels like a hacky way to do this. Ask in hw review.


}
