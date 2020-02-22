package Actions;

import Characters.Character;

import java.util.ArrayList;

public class Battle {

    private ArrayList<Character> healthyCharacters;
    private ArrayList<Character> kOCharacters;
    private ArrayList<Character> healthyEnemies;
    private ArrayList<Character> kOEnemies;

    public Battle() {
        this.healthyCharacters = new ArrayList<Character>();
        this.kOCharacters = new ArrayList<Character>();
        this.healthyEnemies = new ArrayList<Character>();
        this.kOEnemies = new ArrayList<Character>();
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

    public void initializeBattle(ArrayList<Character> characters, ArrayList<Character> enemies){
        for (Character character: characters){
            if (character.getHealthPoints() > 0){
                healthyCharacters.add(character);
            } else {
                kOCharacters.add(character);
            }
        }

        for (Character enemy: enemies){
            if (enemy.getHealthPoints() > 0){
                healthyEnemies.add(enemy);
            } else {
                kOEnemies.add(enemy);
            }
        }
    }

    public void battleRound(){
        for (Character character : this.healthyCharacters){
            character.battleAction();
        }
    }

//    public void battleUntilWinner(){
//        while (this.getHealthyCharactersCount() > 0 && this.getKOCharactersCount() > 0){
//            this.battleRound();
//        }
//    }
}
