package com.github.aale12.game;

public class PlayerCharacter extends Character {
  private int score;
  private int gold;

  public PlayerCharacter(int Hp, int attack, String name, int score) {
    super(Hp, attack, name);
    this.score = score;
  }

  public void increaseScore() {
    this.score++;
  }

  public int getScore() {
    return this.score;
  }

  public int setScore(int newScore) {
    this.score = newScore;
    return this.score;
  }

  public int getGold() {
    return this.gold;
  }

  public int setGold(int gold) {
    return this.gold = gold;
  }
}