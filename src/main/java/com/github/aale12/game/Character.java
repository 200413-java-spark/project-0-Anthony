package com.github.aale12.game;

abstract class Character {
  private int Hp;
  private int attack;
  private String name;

  public Character(int Hp, int attack, String name) {
    this.Hp = Hp;
    this.attack = attack;
    this.name = name;
  }

  public int getHp() {
    return this.Hp;
  }

  public int setHp(int Hp) {
    return this.Hp = Hp;
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