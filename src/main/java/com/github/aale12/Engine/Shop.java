package com.github.aale12.Engine;

import com.github.aale12.game.PlayerCharacter;

public class Shop {
  public static void shopMenu() {
    System.out.println("Would you like to buy or sell?");
    System.out.println("1) Buy");
    System.out.println("2) Sell");
    System.out.println("3) Exit");
  }

  public static void shopBuyMenu(PlayerCharacter Player) {
    System.out.println("What would you like to buy?");
    System.out.println(Player.getGold() + " gold remaining.");
    System.out.println("1) Potion: 30 Gold");
    System.out.println("2) Large Potion: 60 Gold");
    System.out.println("3) Exit");
  }

  public static void shopSellMenu(PlayerCharacter Player) {
    System.out.println("What would you like to sell?");
    System.out.println("1) " + Player.getSmTrinketCt() + "x Bronze Monster Trinket: 20 Gold");
    System.out.println("2) " + Player.getMdTrinketCt() + "x Silver Monster Trinket: 40 Gold");
    System.out.println("3) " + Player.getLgTrinketCt() + "x Gold Monster Trinket: 80 Gold");
    System.out.println("4) Exit");
  }

  public static void shopBuyPotion(PlayerCharacter Player, String potion) {
    switch (potion) {
      case "Potion":
        if (Player.getGold() < 30) {
          System.out.println("You don't have enough gold! Try selling some monster trinkets.");
        } else {
          Player.setGold(Player.getGold() - 30);
          Player.setPotionCt(Player.getPotionCt() + 1);
          System.out.println("You bought a potion for 30 gold.");
          System.out.println("You now have " + Player.getGold() + " gold remaining.");

        }
        break;
      case "Large Potion":
        if (Player.getGold() < 60) {
          System.out.println("You don't have enough gold! Try selling some monster trinkets.");
        } else {
          Player.setGold(Player.getGold() - 60);
          Player.setLgPotionCt(Player.getLgPotionCt() + 1);
          System.out.println("You bought a large potion for 60 gold.");
          System.out.println("You now have " + Player.getGold() + " gold remaining.");
        }
      default:
        break;
    }
  }

  public static void shopSellTrinket(PlayerCharacter Player, String trinket) {
    switch (trinket) {
      case "small":
        if (Player.getSmTrinketCt() < 1) {
          System.out.println("You don't have any trinkets! Try killing some monsters.");
          break;
        } else {
          Player.setGold(Player.getGold() + Player.getSmTrinketCt() * 20);
          System.out.println("You sold " + Player.getSmTrinketCt() + " bronze monster trinkets for "
              + Player.getSmTrinketCt() * 20 + " gold.");
          System.out.println("You now have " + Player.getGold() + " gold.");
          Player.setSmTrinketCt(0);
          break;
        }
      case "medium":
        if (Player.getMdTrinketCt() < 1) {
          System.out.println("You don't have any trinkets! Try killing some monsters.");
          break;
        } else {
          Player.setGold(Player.getGold() + Player.getMdTrinketCt() * 40);
          System.out.println("You sold " + Player.getMdTrinketCt() + " silver monster trinkets for "
              + Player.getMdTrinketCt() * 40 + " gold.");
          System.out.println("You now have " + Player.getGold() + " gold.");
          Player.setMdTrinketCt(0);
          break;
        }
      case "large":
        if (Player.getLgTrinketCt() < 1) {
          System.out.println(
              "You don't have any trinkets! Try killing some monsters. Powerful monsters drop better trinkets.");
          break;
        } else {
          Player.setGold(Player.getGold() + Player.getLgTrinketCt() * 80);
          System.out.println("You sold " + Player.getLgTrinketCt() + " golden monster trinkets for "
              + Player.getLgTrinketCt() * 20 + " gold.");
          System.out.println("You now have " + Player.getGold() + " gold.");
          Player.setLgTrinketCt(0);
          break;
        }
    }
  }
}