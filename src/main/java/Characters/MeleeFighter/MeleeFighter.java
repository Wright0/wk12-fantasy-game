package Characters.MeleeFighter;

import Items.Weapons.Weapon;
import Characters.Character;

public abstract class MeleeFighter extends Character {
    protected Weapon weapon;

    public MeleeFighter(String name, int healthPoints) {
        super(name, healthPoints);
        weapon = null;
    }

    public void receiveNewWeapon(Weapon newItem){
        this.weapon = newItem;
    }

    public void battleAction(Character character){
        character.takeHealthDamage(this.weapon.getAttackPower());
    }
}
