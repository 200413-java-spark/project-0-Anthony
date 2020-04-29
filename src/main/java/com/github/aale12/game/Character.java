package com.github.aale12.game;

abstract class Character {
  private int health;
  private int attack;
  private String name;

  public Character(int health, int attack, String name) {
    this.health = health;
    this.attack = attack;
    this.name = name;
  }

  public int getHealth() {
    return this.health;
  }

  public int setHealth(int health) {
    return this.health = health;
  }

  public int getAttack() {
    return this.attack;
  }

  public int setAttack(int attack) {
    return this.attack = attack;
  }

  public String getName() {
    return this.name;
  }

}