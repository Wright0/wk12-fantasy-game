package Actions;

import Behaviours.IAttack;
import Characters.Character;

import java.util.ArrayList;

public class Battle {

    private ArrayList<Character> healthyCharacters;
    private ArrayList<Character> kOCharacters;
    private ArrayList<IAttack> healthyEnemies;
    private ArrayList<IAttack> kOEnemies;

    public Battle() {
        this.healthyCharacters = new ArrayList<Character>();
        this.kOCharacters = new ArrayList<Character>();
        this.healthyEnemies = new ArrayList<IAttack>();
        this.kOEnemies = new ArrayList<IAttack>();
    }

    public void initializeBattle(ArrayList<Character> characters, ArrayList<IAttack> enemies){
        for (Character character: characters){
            if (character.getHealthPoints() > 0){
                healthyCharacters.add(character);
            } else {
                kOCharacters.add(character);
            }
        }

        for (IAttack enemy: enemies){
            if (enemy.getHealthPoints() > 0){
                healthyEnemies.add(enemy);
            } else {
                kOEnemies.add(enemy);
            }
        }
    }

    public int getHealthyCharactersCount(){
        return this.healthyCharacters.size();
    }

    public int getKOCharactersCount(){
        return this.kOCharacters.size();
    }

    public int getHealthyEnemiesCount(){
        return this.healthyEnemies.size();
    }

    public int getKOEnemiesCount(){
        return this.kOEnemies.size();
    }



}
