package com.github.aale12.Engine;

import com.github.aale12.game.NonPlayerCharacter;
import com.github.aale12.game.PlayerCharacter;

public class PostCombat {
  public static void enemyDefeated(PlayerCharacter Player, NonPlayerCharacter Enemy) {
    Player.increaseScore();

    System.out.println("================================================");
    System.out.println(Enemy.getName() + " was defeated!\n Your Score: " + Player.getScore());
    PostCombat.awardTrinket(Player, Enemy);
    System.out.println("================================================");
    System.out.println("1) Continue");
    System.out.println("2) Save");
    System.out.println("3) Exit");
  }

  public static void awardTrinket(PlayerCharacter Player, NonPlayerCharacter Enemy) {
    double rand = Math.random();
    switch (Enemy.getName()) {
      case "Bandit":
        if (rand < .7) {
          Player.setSmTrinketCt(Player.getSmTrinketCt() + 1);
          System.out.println("The Bandit dropped a bronze trinket! You now have " + Player.getSmTrinketCt()
              + " bronze monster trinkets!");
          break;
        } else {
          break;
        }
      case "Witch":
        if (rand < 0.5) {
          Player.setSmTrinketCt(Player.getSmTrinketCt() + 1);
          System.out.println("The Witch dropped a bronze trinket!\n You now have " + Player.getSmTrinketCt()
              + " bronze monster trinkets!");
          break;
        } else if (rand > 0.8) {
          Player.setMdTrinketCt(Player.getMdTrinketCt() + 1);
          System.out.println("The Witch dropped a silver trinket!\n You now have " + Player.getMdTrinketCt()
              + " silver monster trinkets!");
          break;
        }
      case "Werewolf":
        if (rand < 0.2) {
          Player.setSmTrinketCt(Player.getSmTrinketCt() + 1);
          System.out.println("The Werewolf dropped a bronze trinket!\n You now have " + Player.getSmTrinketCt()
              + " bronze monster trinkets!");
          break;
        } else if (0.2 < rand && rand < 0.7) {
          Player.setMdTrinketCt(Player.getMdTrinketCt() + 1);
          System.out.println("The Werewolf dropped a silver trinket!\n You now have " + Player.getMdTrinketCt()
              + " silver monster trinkets!");
          break;
        } else {
          Player.setLgTrinketCt(Player.getLgTrinketCt() + 1);
          System.out.println("The Werefolf dropped a golden trinket!\n You now have " + Player.getLgTrinketCt()
              + " golden monster trinkets!");
        }
      case "Demon":
        if (rand < 0.6) {
          Player.setMdTrinketCt(Player.getMdTrinketCt() + 1);
          System.out.println("The Demon dropped a silver trinket!\n You now have " + Player.getMdTrinketCt()
              + " silver monster trinkets!");
          break;
        } else if (rand >= 0.6) {
          Player.setLgTrinketCt(Player.getLgTrinketCt() + 1);
          System.out.println("The Witch dropped a golden trinket!\n You now have " + Player.getLgTrinketCt()
              + " golden monster trinkets!");
          break;
        }
    }
  }
}