package com.github.aale12.game;

public class PlayerCharacter extends Character {
  public int killStreak;

  public PlayerCharacter(int Hp, int attack, String name, int killStreak) {
    super(Hp, attack, name);
    this.killStreak = killStreak;
  }

  public void increaseKillStreak() {
    this.killStreak++;
  }

  public int getKillStreak() {
    return this.killStreak;
  }
}