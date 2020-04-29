package com.github.aale12.game;

public class PlayerCharacter extends Character {
  private int score;
  private int gold;
  private int smTrinketCt;
  private int mdTrinketCt;
  private int lgTrinketCt;
  private int potionCt;
  private int lgPotionCt;

  public PlayerCharacter(int attack, String name, int health, int score, int gold, int potionCt, int lgPotionCt,
      int smTrinketCt, int mdTrinketCt, int lgTrinketCt) {
    super(health, attack, name);
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

  // potions
  public int getPotionCt() {
    return this.potionCt;
  }

  public int setPotionCt(int potionCt) {
    return this.potionCt = potionCt;
  }

  // large potions
  public int getLgPotionCt() {
    return this.lgPotionCt;
  }

  public int setLgPotionCt(int lgPotionCt) {
    return this.lgPotionCt = lgPotionCt;
  }

  // small trinkets
  public int getSmTrinketCt() {
    return this.smTrinketCt;
  }

  public int setSmTrinketCt(int smTrinketCt) {
    return this.smTrinketCt = smTrinketCt;
  }

  // medium trinkets
  public int getMdTrinketCt() {
    return this.mdTrinketCt;
  }

  public int setMdTrinketCt(int mdTrinketCt) {
    return this.mdTrinketCt = mdTrinketCt;
  }

  // large trinkets
  public int getLgTrinketCt() {
    return this.lgTrinketCt;
  }

  public int setLgTrinketCt(int lgTrinketCt) {
    return this.lgTrinketCt = lgTrinketCt;
  }
}