package PlayerTests;

import Items.Weapons.Club;
import Items.Weapons.Sword;
import Characters.Healer.Cleric;
import Characters.MeleeFighter.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {
    Knight knight;
    Sword sword;
    Cleric cleric;
    Club club;

    @Before
    public void before(){
        knight = new Knight("Dave", 50, "Elric");
        cleric = new Cleric("Fred", 50);
        sword = new Sword("Long sword", 10, 2);
        club = new Club("Club", 8);
    }

    @Test
    public void canAttackEnemyWithPreferredWeapon(){
        knight.receiveNewWeapon(sword);
        knight.attack(cleric);
        assertEquals(35, cleric.getHealthPoints());
    }

    @Test
    public void canAttackEnemyWithNonPreferredWeapon(){
        knight.receiveNewWeapon(club);
        knight.attack(cleric);
        assertEquals(42, cleric.getHealthPoints());
    }
}
