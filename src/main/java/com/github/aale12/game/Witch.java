package com.github.aale12.game;

public class Witch extends NonPlayerCharacter {

  public Witch(int attack, String name, int health, double attackModifier, double defenseModifier, double dropChance) {
    super(attack, name, health, attackModifier, defenseModifier, dropChance);
    // this.setAttackModifier(1.4);
    // this.setDefenseModifier(0.7);
    // this.setDropChance(0.3);
  }

}