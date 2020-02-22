package Rooms;

import Items.Treasure;
import Characters.Character;

import java.util.ArrayList;

public class Room {

    private ArrayList<Treasure> treasures;
    private ArrayList<Character> characters;

    public Room(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
        this.characters = new ArrayList<Character>();
    }

    public void addPlayer(Character character){
        this.characters.add(character);
    }

    public int getPlayerCount() {
        return this.characters.size();
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
