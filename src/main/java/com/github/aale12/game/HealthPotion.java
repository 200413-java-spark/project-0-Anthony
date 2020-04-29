package com.github.aale12.game;

public class HealthPotion extends Item {
  private int healAmount = 35;

  public HealthPotion(String name, String description, int value) {
    super(name, description, value);
  }

  public int getHealAmount(int healAmount) {
    return this.healAmount;
  }

  public int setHealAmount(int healAmount) {
    return this.healAmount = healAmount;
  }

}