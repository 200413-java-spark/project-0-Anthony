package com.github.aale12.Engine;

public class PreCombat {
  public static void preCombatMenu() {
    System.out.println("> You are in Town! What would you like to do?\n");
    System.out.println("1) Battle");
    System.out.println("2) Shop");
    System.out.println("3) Save");
    System.out.println("4) Exit");
  }

  // public static void preCombatBattle() {
  // Combat.BattleStart();
  // }

  public static void preCombatShop() {
    Shop.shopMenu();
  }

  public static void preCombatSave(int health, int score, int gold, int potionCt, int lgPotionCt, int smTrinketCt,
      int mdTrinketCt, int lgTrinketCt) {
  }
}