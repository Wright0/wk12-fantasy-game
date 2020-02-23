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

    public int getHealthyCharacterCount(){
        return this.healthyCharacters.size();
    }

    public ArrayList<Character> getHealthyCharacters(){
        ArrayList<Character> healthyCharactersCopy = healthyCharacters;
        return healthyCharactersCopy;
    }

    public int getKOCharacterCount(){
        return this.kOCharacters.size();
    }

    public int getHealthyEnemyCount(){
        return this.healthyEnemies.size();
    }

    public ArrayList<Character> getHealthyEnemies(){
        ArrayList<Character> healthyEnemiesCopy = healthyEnemies;
        return healthyEnemiesCopy;
    }

    public int getKOEnemyCount(){
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

    public void updateBattleGroups(){
        ArrayList<Character> newlyDeadCharacters = new ArrayList<Character>();
        for (Character character: this.healthyCharacters){
            if (character.getHealthPoints() <= 0){
                this.kOCharacters.add(character);
                newlyDeadCharacters.add(character);
            }
        }
        this.healthyCharacters.removeAll(newlyDeadCharacters);

        ArrayList<Character> newlyDeadEnemies= new ArrayList<Character>();
        for (Character enemy: this.healthyEnemies){
            if (enemy.getHealthPoints() <= 0){
                this.kOEnemies.add(enemy);
                newlyDeadEnemies.add(enemy);
            }
        }
        this.healthyEnemies.removeAll(newlyDeadEnemies);
    }

    public int battleRound(Character selectedCharacter, String action, Character target){
        int battleActionValue = selectedCharacter.battleAction(action, target);
        return battleActionValue;
    }

    public boolean canBattleContinue(){
        return this.getHealthyCharacterCount() > 0 && this.getHealthyEnemyCount() > 0;
    }

    public String determineWinner(){
        if (this.getHealthyEnemyCount() == 0){
            return "You";
        } else {
            return "The enemy";
        }
    }
}
