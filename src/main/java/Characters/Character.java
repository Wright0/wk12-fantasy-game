package Characters;

import Items.Treasure;

import java.util.ArrayList;

public abstract class Character {

    private String name;
    private int healthPoints;
    private ArrayList<Treasure> wallet;
    protected String battleOption;

    public Character(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.wallet = new ArrayList<Treasure>();
        this.battleOption = null;
    }

    public String getName(){
        return this.name;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public int getWalletValue() {
        int walletValue = 0;
        for ( Treasure treasure : this.wallet ){
            walletValue += treasure.getValue();
        }
        return walletValue;
    }

    public void takeHealthDamage(int amountToRemove){
        this.healthPoints -= amountToRemove;
    }

    public void beHealed(int amountToAdd){
        this.healthPoints += amountToAdd;
    }

    public void addTreasure(Treasure treasure){
        this.wallet.add(treasure);
    }

    public abstract int battleAction(String action, Character target);

    public String getBattleOption(){
        return this.battleOption;
    };

}
