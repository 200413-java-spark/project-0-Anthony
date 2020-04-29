package com.github.aale12.game;

public class Bandit extends NonPlayerCharacter {

  public Bandit(int attack, String name, int health, double attackModifier, double defenseModifier, double dropChance) {
    super(attack, name, health, attackModifier, defenseModifier, dropChance);
    // this.setAttackModifier(0.8);
    // this.setDefenseModifier(1.1);
    // this.setDropChance(0.25);
  }

}