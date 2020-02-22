package BattleTest;

import Actions.Battle;
import Characters.Healer.Cleric;
import Characters.MeleeFighter.Knight;
import Characters.Character;

import Items.Weapons.Club;
import Items.Weapons.Sword;
import Items.Weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BattleTest {

    private Battle battle;
    private Cleric c3p0;
    private Knight rey;
    private Knight anakin;
    private Knight kylo;
    private Weapon sword;
    private Weapon club;

    ArrayList<Character> characters;
    ArrayList<Character> enemies;

    @Before
    public void before(){
        battle = new Battle();

        c3p0 = new Cleric("C3-P0", 0);
        rey = new Knight("Rey", 40, "Jedi");
        anakin = new Knight("Anakin", 0, "Sith");
        kylo = new Knight ("Kylo", 35, "Sith");

        sword = new Sword("Sword", 15, 2);
        club = new Club("Club", 10);

        kylo.receiveNewWeapon(club);
        rey.receiveNewWeapon(sword);

        characters = new ArrayList<Character>();
        characters.add(rey);
        characters.add(c3p0);

        enemies = new ArrayList<Character>();
        enemies.add(anakin);
        enemies.add(kylo);
    }

    @Test
    public void canAddCharactersToCorrectListBasedOnHealth(){
        battle.initializeBattle(characters, enemies);
        assertEquals(1, battle.getHealthyCharactersCount());
        assertEquals(1, battle.getHealthyEnemiesCount());
        assertEquals(1, battle.getKOCharactersCount());
        assertEquals(1, battle.getKOEnemiesCount());
    }

    @Test
    public void

}

