package com.github.aale12.game;

abstract class Character {
  public int Hp;
  public int attack;
  public String name;

  public Character(int Hp, int attack, String name) {
    this.Hp = Hp;
    this.attack = attack;
    this.name = name;
  }

  public int getHp() {
    return this.Hp;
  }

  public int setHp(int Hp) {
    this.Hp = Hp;
    return this.Hp;
  }

  public int getAttack() {
    return this.attack;
  }

  public String getName() {
    return this.name;
  }

}