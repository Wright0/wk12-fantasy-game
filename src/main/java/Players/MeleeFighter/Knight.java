package Players.MeleeFighter;

import Players.Player;

public class Knight extends MeleeFighter {

    private String preferredWeapon;
    private int preferredWeaponMultiplier;

    public Knight(String name, int healthPoints) {
        super(name, healthPoints);
        this.preferredWeapon = "Long sword";
        this.preferredWeaponMultiplier = 50;
    }

    @Override
    public void attack(Player player){
        if (this.weapon.getName().equals(preferredWeapon)){
            int attackMultiplierValue = 0;
            attackMultiplierValue = (this.weapon.getAttackPower() * preferredWeaponMultiplier) / 100;
            player.takeHealthDamage(this.weapon.getAttackPower() + attackMultiplierValue);
        } else {
        super.attack(player);
        }
    }

}
