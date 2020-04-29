package com.github.aale12.game;

public class Demon extends NonPlayerCharacter {

  public Demon(int attack, String name, int health, double attackModifier, double defenseModifier, double dropChance) {
    super(attack, name, health, attackModifier, defenseModifier, dropChance);
    // this.setAttackModifier(1.3);
    // this.setDefenseModifier(1.8);
    // this.setDropChance(1.0);
  }

}