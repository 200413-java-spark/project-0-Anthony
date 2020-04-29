package com.github.aale12.game;

public class Item {
  private int value;
  private String description;
  private String name;

  public Item(String name, String description, int value) {
    this.value = value;
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return this.name;
  }

  public int getvalue() {
    return this.value;
  }

  public String getDescription() {
    return this.description;
  }

  public int setvalue(int value) {
    return this.value = value;
  }

  public String setDescription(String description) {
    return this.description = description;
  }
}