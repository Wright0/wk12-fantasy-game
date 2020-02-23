package Characters.MeleeFighter;

import Characters.Character;

public class Knight extends MeleeFighter {

    private String preferredWeapon;
    private int preferredWeaponMultiplier;
    private String knightsOrder;

    public Knight(String name, int healthPoints, String knightsOrder) {
        super(name, healthPoints);
        this.preferredWeapon = "Long sword";
        this.preferredWeaponMultiplier = 50;
        this.knightsOrder = knightsOrder;
    }

    @Override
    public int battleAction(String action, Character character){
        if (action.equals("attack")){
            if (this.weapon.getName().equals(preferredWeapon)){
                int attackMultiplierValue = 0;
                attackMultiplierValue = (this.weapon.getAttackPower() * preferredWeaponMultiplier) / 100;
                character.takeHealthDamage(this.weapon.getAttackPower() + attackMultiplierValue);
                return this.weapon.getAttackPower() + attackMultiplierValue;
            } else {
                super.attack(character);
                return this.weapon.getAttackPower();
            }
        } return 0;
    }

}
