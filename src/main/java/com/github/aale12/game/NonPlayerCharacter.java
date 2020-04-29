package com.github.aale12.game;

public class NonPlayerCharacter extends Character {
  private double attackModifier;
  private double defenseModifier;
  private double dropChance;

  public NonPlayerCharacter(int attack, String name, int health, double attackModifier, double defenseModifier,
      double dropChance) {
    super(health, attack, name);
    this.attackModifier = attackModifier;
    this.defenseModifier = defenseModifier;
    this.dropChance = dropChance;
  }

  // getters
  public double getAttackModifier() {
    return this.attackModifier;
  }

  public double getDefenceModifier() {
    return this.defenseModifier;
  }

  public double getDropChance() {
    return this.dropChance;
  }

  // setters
  public double setAttackModifier(double attackModifier) {
    return this.attackModifier = attackModifier;
  }

  public double setDefenseModifier(double defenseModifier) {
    return this.defenseModifier = defenseModifier;
  }

  public double setDropChance(double dropChance) {
    return this.dropChance = dropChance;
  }
}