package com.github.aale12.Engine;

import java.sql.SQLException;
import java.util.Scanner;

import com.github.aale12.game.NonPlayerCharacter;
import com.github.aale12.game.PlayerCharacter;
import com.github.aale12.io.SqlDataManagement;

public class Engine {
  public static void run() throws NumberFormatException, SQLException {
    // pregame loading
    // create enemy placeholder
    NonPlayerCharacter Enemy = Combat.createEnemy();
    // create player placeholder
    PlayerCharacter Player = new PlayerCharacter(40, "NoName", 100, 0, 0, 2, 0, 0, 0, 0);
    // scan to see if character is dead or not, if dead, ask for a name and create
    // new default character
    Scanner userInput = new Scanner(System.in);
    String[] localFile;
    if (!PreGame.characterStatusCheck()) {
      PreGame.newGamePrompt();
      String input = userInput.nextLine();
      Player = new PlayerCharacter(5, input, 100, 0, 0, 2, 0, 0, 0, 0);
      SqlDataManagement.setSqlCharacterStatus(true);
      // is character is alive, load character
    } else if (PreGame.characterStatusCheck()) {
      localFile = PreGame.loadCharacterData().split(",");
      Player = new PlayerCharacter(40, localFile[1], Integer.parseInt(localFile[2]), Integer.parseInt(localFile[3]),
          Integer.parseInt(localFile[4]), Integer.parseInt(localFile[5]), Integer.parseInt(localFile[6]),
          Integer.parseInt(localFile[7]), Integer.parseInt(localFile[8]), Integer.parseInt(localFile[9]));
    }
    // game is now loaded and running
    boolean isRunning = true;
    boolean isFighting = false;
    GAME: while (isRunning) {
      System.out.println("\nWelcome back " + Player.getName() + "!");
      System.out.println("----------------------------------------------------------");
      PreCombat.preCombatMenu();
      String input = userInput.nextLine();

      if (input.equals("1")) {
        Enemy = Combat.createEnemy();
        isFighting = true;
        System.out.println("\n\t~ " + Enemy.getName() + " has appeared! ~");
        if (isFighting) {
          while (Enemy.getHealth() > 0) {
            Combat.BattleStart(Player, Enemy);
            input = userInput.nextLine();
            if (input.equals("1")) {
              Combat.PlayerAttack(Player, Enemy);
              if (Player.getHealth() <= 0) {
                System.out.println("You have died!");
                break;
              }
            } else if (input.equals("2")) {
              Combat.PlayerDefend(Player, Enemy);
              if (Player.getHealth() <= 0) {
                break;
              }
            } else if (input.equals("3")) {
              Combat.PlayerPotion("Potion", Player, Enemy);
              if (Player.getHealth() <= 0) {
                break;
              }
            } else if (input.equals("4")) {
              Combat.PlayerPotion("lgPotion", Player, Enemy);
              if (Player.getHealth() <= 0) {
                break;
              }
            } else if (input.equals("5")) {
              Combat.PlayerFlee(Player, Enemy);
              if (Player.getHealth() <= 0) {
                break;
              }
              continue GAME;
            } else {
              System.out.println("Invalid Command!");
            }
          }
        }

        // shop menu
      } else if (input.equals("2")) {
        isFighting = false;
        Shop.shopMenu();
        input = userInput.nextLine();
        // buy menu
        if (input.equals("1")) {
          Shop.shopBuyMenu(Player);
          input = userInput.nextLine();
          if (input.equals("1")) {
            Shop.shopBuyPotion(Player, "Potion");
            continue GAME;
          } else if (input.equals("2")) {
            Shop.shopBuyPotion(Player, "Large Potion");
            continue GAME;
          } else if (input.equals("3")) {
            continue GAME;
          } else {
            System.out.println("Invalid Command");
            continue GAME;
          }
          // sell menu
        } else if (input.equals("2")) {
          Shop.shopSellMenu(Player);
          input = userInput.nextLine();
          if (input.equals("1")) {
            Shop.shopSellTrinket(Player, "small");
            continue GAME;
          } else if (input.equals("2")) {
            Shop.shopSellTrinket(Player, "medium");
            continue GAME;
          } else if (input.equals("3")) {
            Shop.shopSellTrinket(Player, "large");
            continue GAME;
          } else if (input.equals("4")) {
            continue GAME;
          } else {
            System.out.println("Invalid Command");
            continue GAME;
          }
        } else if (input.equals("3")) {
          continue GAME;
        } else {
          System.out.println("Invalid Command");
          continue GAME;
        }
      } else if (input.equals("3")) {
        SqlDataManagement.saveGameSql(Player);
      } else if (input.equals("4")) {
        SqlDataManagement.saveGameSql(Player);
        break;
      }
      // when you die
      if (Player.getHealth() <= 0) {
        isFighting = false;
        SqlDataManagement.setSqlCharacterStatus(false);
        System.out.println("You've Died!\r\n");
        System.out.println("#############");
        System.out.println("# Game Over #");
        System.out.println("#############");
        break;
      }
      // if enemy defeated
      if (Enemy.getHealth() < 1) {
        isFighting = false;
        PostCombat.enemyDefeated(Player, Enemy);
        input = userInput.nextLine();
        if (input.equals("1")) {
          System.out.println("You continue the next fight");
        } else if (input.equals("2")) {
          SqlDataManagement.saveGameSql(Player);
        } else if (input.equals("3")) {
          SqlDataManagement.saveGameSql(Player);
          System.out.println("You exit the game!");
          break;
        } else {
          System.out.println("Invalid Command");
          continue GAME;
        }
      }
    }
    System.out.println("\nThanks for playing!");
    userInput.close();
  }

}