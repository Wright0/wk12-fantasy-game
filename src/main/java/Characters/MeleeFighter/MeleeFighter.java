package Players.MeleeFighter;

import Behaviours.IAttack;
import Items.Weapons.Weapon;
import Players.Character;

public abstract class MeleeFighter extends Character implements IAttack {
    protected Weapon weapon;

    public MeleeFighter(String name, int healthPoints) {
        super(name, healthPoints);
        weapon = null;
    }

    public void receiveNewWeapon(Weapon newItem){
        this.weapon = newItem;
    }

    public Weapon getWeapon(){
        return this.weapon;
    }

    public void attack(Character character){
        character.takeHealthDamage(this.weapon.getAttackPower());
    }
}
