package Items.Weapons;

public class Sword extends Weapon {

    private int handsNeededToWield;

    public Sword(String name, int attackPower, int handsNeededToWield) {
        super(name, attackPower);
        this.handsNeededToWield = handsNeededToWield;
    }

}
