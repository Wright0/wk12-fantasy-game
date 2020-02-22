package Players.MeleeFighter;

import Items.Weapons.Weapon;
import Players.Player;

public abstract class MeleeFighter extends Player {
    private Weapon weapon;

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

    public void attack(Player player){
        player.takeHealthDamage(this.weapon.getAttackPower());
    }
}
