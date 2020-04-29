package com.github.aale12.game;

public class Werewolf extends NonPlayerCharacter {

  public Werewolf(int attack, String name, int health, double attackModifier, double defenseModifier,
      double dropChance) {
    super(attack, name, health, attackModifier, defenseModifier, dropChance);
    // this.setAttackModifier(1.4);
    // this.setDefenseModifier(1.4);
    // this.setDropChance(0.6);
  }

}