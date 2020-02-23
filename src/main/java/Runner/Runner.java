package Runner;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

import Actions.Battle;
import Characters.Character;
import Characters.Healer.Cleric;
import Characters.MeleeFighter.Knight;
import Items.Weapons.Club;
import Items.Weapons.Sword;
import Items.Weapons.Weapon;

import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Battle battle = new Battle();

        Cleric c3p0 = new Cleric("C3-P0", 0);
        Knight obiwan = new Knight("Obi-wan", 50, "Jedi");
        Knight rey = new Knight("Rey", 40, "Jedi");

        Knight anakin = new Knight("Anakin", 80, "Sith");
        Knight kylo = new Knight ("Kylo", 35, "Sith");

        Weapon sword = new Sword("Long sword", 15, 2);
        Weapon sword2 = new Sword("Short sword", 9, 1);
        Weapon club = new Club("Club", 10);
        Weapon sword3 = new Sword("Long sword", 9, 1);

        kylo.receiveNewWeapon(club);
        anakin.receiveNewWeapon(sword3);
        obiwan.receiveNewWeapon(sword2);
        rey.receiveNewWeapon(sword);

        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(rey);
        characters.add(obiwan);
        characters.add(c3p0);

        ArrayList<Character>  enemies = new ArrayList<Character>();
        enemies.add(anakin);
        enemies.add(kylo);

        battle.initializeBattle(characters, enemies);

        System.out.println("The teams are ready! Let the battle commence.");

        while (battle.canBattleContinue()) {
            System.out.println("PLAYER'S TURN");
            for (int i = 0; i < battle.getHealthyCharacterCount(); i++){
                int enemySelectedNumber = 0;
                Character enemySelected = null;

                Character activeCharacter = battle.getHealthyCharacters().get(i);
                System.out.println(String.format("It's %1$s's turn. Their available battle action is: %2$s. Select the number of your desired target:", activeCharacter.getName(), activeCharacter.getBattleOption()));

                for (int j = 0; j < battle.getHealthyEnemyCount(); j++) {
                    Character enemy = battle.getHealthyEnemies().get(j);
                    System.out.println(String.format("%d. %s - %d health points", j + 1, enemy.getName(), enemy.getHealthPoints()));
                }

                String target = scanner.next();
                enemySelectedNumber = parseInt(target);

                enemySelected = battle.getHealthyEnemies().get(enemySelectedNumber - 1);

                int battleRoundValue = battle.battleRound(activeCharacter, activeCharacter.getBattleOption(), enemySelected);
                battle.updateBattleGroups();

                System.out.println(String.format("%1$s %2$ss %3$s!", activeCharacter.getName(), activeCharacter.getBattleOption(), enemySelected.getName()));
                System.out.println(String.format("%s takes %d damage.", enemySelected.getName(), battleRoundValue));
            }

            System.out.println("ENEMY'S TURN:");

            for (int i = 0; i < battle.getHealthyEnemyCount(); i++){
                Character activeEnemy = battle.getHealthyEnemies().get(i);
                Character chosenCharacter = battle.getHealthyCharacters().get(i);

                int battleRoundValue = battle.battleRound(activeEnemy, activeEnemy.getBattleOption(), chosenCharacter);
                battle.updateBattleGroups();
                System.out.println(String.format("%1$s %2$ss %3$s!", activeEnemy.getName(), activeEnemy.getBattleOption(), chosenCharacter.getName()));
                System.out.println(String.format("%s takes %d damage", chosenCharacter.getName(), battleRoundValue));

            }
        }

        System.out.println(String.format("The battle is over! %s won!", battle.determineWinner()));
    }
}
