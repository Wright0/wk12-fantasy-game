package Behaviours;

import Characters.Character;

public interface IAttack {

    void attack(Character character);
    int getHealthPoints();
    void takeHealthDamage(int amountToRemove);

}
