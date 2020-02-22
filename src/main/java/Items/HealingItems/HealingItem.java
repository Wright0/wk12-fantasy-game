package Items.HealingItems;

import Items.Item;

public class HealingItem extends Item {

    private int healingPower;

    public HealingItem(String name, int healingPower) {
        super(name);
        this.healingPower = healingPower;
    }

    public int getHealingPower() {
        return healingPower;
    }
}
