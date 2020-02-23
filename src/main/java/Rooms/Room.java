package Rooms;

import Items.Treasure;
import Characters.Character;

import java.util.ArrayList;

public class Room {

    private ArrayList<Treasure> treasures;
    private ArrayList<Character> playerParty;
    private ArrayList<Character> enemies;

    public Room(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
        this.playerParty = new ArrayList<Character>();
        this.enemies = new ArrayList<Character>();
    }

    public void addPlayer(Character character){
        this.playerParty.add(character);
    }

    public int getPlayerCount() {
        return this.playerParty.size();
    }

    public ArrayList<Treasure> giveTreasure() {
        ArrayList<Treasure> treasuresCopy = new ArrayList<Treasure>(this.treasures);
        this.treasures.clear();
        return treasuresCopy;
    }

    public int getTreasureCount() {
        return this.treasures.size();
    }
}
