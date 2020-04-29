package com.github.aale12.Engine;

import com.github.aale12.game.Bandit;
import com.github.aale12.game.Demon;
import com.github.aale12.game.NonPlayerCharacter;
import com.github.aale12.game.PlayerCharacter;
import com.github.aale12.game.Werewolf;
import com.github.aale12.game.Witch;

public class Combat {
  public static NonPlayerCharacter createEnemy() {
    double rand = Math.random();
    if (rand <= 0.1) {
      Demon demon = new Demon(8, "Demon", 150, 1.3, 1.7, 1.0);
      return demon;
    } else if (rand > 0.1 && rand <= 0.3) {
      Werewolf werewolf = new Werewolf(7, "Werewolf", 120, 1.4, 1.4, 0.6);
      return werewolf;
    } else if (rand > 0.3 && rand <= 0.6) {
      Witch witch = new Witch(6, "Witch", 60, 1.4, 0.7, 0.3);
      return witch;
    } else {
      Bandit bandit = new Bandit(5, "Bandit", 100, 0.8, 1.1, 0.25);
      return bandit;
    }
  }

  public static void BattleStart(PlayerCharacter Player, NonPlayerCharacter Enemy) {
    System.out.println("----------------------------------------------------------");

    System.out.println("\t# Your Health: " + Player.getHealth() + " #");
    System.out.println("\t# " + Enemy.getName() + "'s Health: " + Enemy.getHealth() + " #\n");
    System.out.println("Current Score: " + Player.getScore() + "\n");
    System.out.println("\tWhat to do?");
    System.out.println("\t1) Attack");
    System.out.println("\t2) Guard");
    System.out.println("\t3) Potion: " + Player.getPotionCt());
    System.out.println("\t4) Large Potion: " + Player.getLgPotionCt());
    System.out.println("\t5) Flee");
  }

  public static void PlayerCheckDeath(Integer health) {
    if (health >= 0) {
      System.out.println("\t\t>>You have died!<<");
    }
  }

  public static void PlayerAttack(PlayerCharacter Player, NonPlayerCharacter Enemy) {
    Enemy.setHealth(Enemy.getHealth() - Player.getAttack());
    Player.setHealth(Player.getHealth() - Enemy.getAttack());
    System.out.println("\t> You attack the " + Enemy.getName() + " for " + Player.getAttack() + " damage!");
    System.out.println("\t> You receive " + Enemy.getAttack() + " damage!\n");
  }

  public static void PlayerDefend(PlayerCharacter Player, NonPlayerCharacter Enemy) {
    Player.setHealth(Player.getHealth() - Enemy.getAttack() / 2);
    System.out.println("\t> You brace yourself and receive " + Enemy.getAttack() / 2 + " damage!");
  }

  public static void PlayerPotion(String potion, PlayerCharacter Player, NonPlayerCharacter Enemy) {
    switch (potion) {
      case "Potion":
        Player.setHealth(Player.getHealth() + 30 - Enemy.getAttack());
        System.out.println("\t> You drink a potion, healing 30 health!");
        System.out.println("\t> You now have " + Player.getPotionCt() + " potions left.\n");
        System.out.println("\t> " + Enemy.getName() + " attacks you for " + Enemy.getAttack() + " damage!");
        Player.setPotionCt(Player.getPotionCt() - 1);
        break;
      case "lgPotion":
        Player.setHealth(Player.getHealth() + 60 - Enemy.getAttack());
        System.out.println("\t> You drink a large potion, healing 60 health!");
        System.out.println("\t> You now have " + Player.getLgPotionCt() + " large potions left.");
        System.out.println("\t> " + Enemy.getName() + " attacks you for " + Enemy.getAttack() + " damage!");
        Player.setPotionCt(Player.getLgPotionCt() - 1);
        break;
    }
  }

  public static void PlayerFlee(PlayerCharacter Player, NonPlayerCharacter Enemy) {
    System.out.println("You attempt to run away!");
    Player.setHealth(Player.getHealth() - Enemy.getAttack() * 2);
    System.out.println(Enemy.getName() + " attacks you from behind for " + Enemy.getAttack() * 3 + " damage!");
    System.out.println("You manage to reach town!");
  }
}
