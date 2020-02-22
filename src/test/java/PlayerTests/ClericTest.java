package PlayerTests;

import Items.HealingItems.HealingItem;
import Items.Treasure;
import Characters.Healer.Cleric;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    private Cleric jeff;
    private Cleric bob;
    private HealingItem potion;
    private Treasure gold;

    @Before
    public void before(){
        jeff = new Cleric("Jeff", 10);
        bob = new Cleric("Bob", 20);
        potion = new HealingItem("Potion", 5);
        gold = new Treasure("Gold", 10);
    }

    @Test
    public void canReceiveHealingItem(){
        jeff.receiveNewHealingItem(potion);
        assertEquals("Potion", jeff.getHealingItem().getName());
    }

    @Test
    public void canTakeDamage(){
        jeff.takeHealthDamage(6);
        assertEquals(4, jeff.getHealthPoints());
    }

    @Test
    public void clericCanHealAnotherPlayer(){
        bob.receiveNewHealingItem(potion);
        jeff.takeHealthDamage(6);
        bob.healPlayer(jeff);
        assertEquals(9, jeff.getHealthPoints());
    }

    @Test
    public void clericCanAddTreasureAndGetWalletValue(){
        bob.addTreasure(gold);
        assertEquals(10, bob.getWalletValue());
    }
}
