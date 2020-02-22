package ItemTests;

import Items.Weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwordTest {

    Sword sword;

    @Before
    public void before(){
        sword = new Sword("Sword", 10, 2);
    }

    @Test
    public void canGetWeaponName(){
        assertEquals("Sword", sword.getName());
    }
}
