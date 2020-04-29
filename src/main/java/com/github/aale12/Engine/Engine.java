package com.github.aale12.Engine;

import java.sql.SQLException;
import java.util.Scanner;

import com.github.aale12.game.NonPlayerCharacter;
import com.github.aale12.game.PlayerCharacter;
import com.github.aale12.io.SqlDataManagement;

public class Engine {
  public static void run() {
    // pregame loading
    // create enemy placeholder
    final NonPlayerCharacter Enemy = new NonPlayerCharacter(Health, attack, name);
    // create player placeholder
    final PlayerCharacter Player = new PlayerCharacter(5, "NoName", 100, 0, 0, 0, 0, 0, 0, 0);

    // scan to see if character is dead or not, if dead, ask for a name and create
    // new default character
    Scanner userInput = new Scanner(System.in);
    String[] localFile;
    if (!PreGame.characterStatusCheck()) {
      PreGame.newGamePrompt();
      String input = userInput.nextLine();
      Player = new PlayerCharacter(5, input, 100, 0, 0, 0, 0, 0, 0, 0);
      // is character is alive, load character
    } else if (PreGame.characterStatusCheck()) {
      localFile = PreGame.loadCharacterData().split(",");
      Player = new PlayerCharacter(5, localFile[0], Integer.parseInt(localFile[1]), Integer.parseInt(localFile[2]),
          Integer.parseInt(localFile[3]), Integer.parseInt(localFile[4]), Integer.parseInt(localFile[5]),
          Integer.parseInt(localFile[6]), Integer.parseInt(localFile[7]), Integer.parseInt(localFile[8]));
    }
    // game is now loaded and running
    boolean isRunning = true;
    GAME: while (isRunning) {
      System.out.println("================================================");
      PreCombat.preCombatMenu();
      String input = userInput.nextLine();
      Enemy.setHealth(100);
      System.out.println("~ " + Enemy.getName() + " has appeared! ~\n");

      while (Enemy.getHealth() > 0) {
        System.out.println("# Your Health: " + Player.getHealth() + " #");
        System.out.println("# " + Enemy.getName() + "'s Health: " + Enemy.getHealth() + " #");
        System.out.println("Current Score: " + Player.getScore());
        System.out.println("What to do?");
        System.out.println("1) Attack");
        System.out.println("2) Run");

        input = userInput.nextLine();
        if (input.equals("1")) {
          Enemy.setHealth(Enemy.getHealth() - Player.getAttack());
          Player.setHealth(Player.getHealth() - Enemy.getAttack());
          System.out.println("> You attack the " + Enemy.getName() + " for " + Player.getAttack() + " damage!");
          System.out.println("> You recieve " + Enemy.getAttack() + " damage!");

          if (Player.getHealth() <= 0) {
            System.out.println("> You have died!");
            break;
          }
        } else if (input.equals("2")) {
          System.out.println("You ran away...into another Enemy!");
          Enemy.setHealth(100);
          continue GAME;
        } else {
          System.out.println("Invalid Command!");
        }
      }
      // when you die
      if (Player.getHealth() <= 0) {
        Player.setScore(0);
        System.out.println("Game Over!");
        break;
      }
      // if enemy defeated
      Player.increaseScore();
      System.out.println("================================================");
      System.out.println(Enemy.getName() + " was defeated!\n Your Score: " + Player.getScore());
      // System.out.println("You heal your wounds.");
      // Player.setHealth(100);
      System.out.println("================================================");
      System.out.println("1) Continue Fighting");
      System.out.println("2) Save");
      System.out.println("3) Exit");

      input = userInput.nextLine();

      while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
        System.out.println("Invalid Command");
        input = userInput.nextLine();
      }
      if (input.equals("1")) {
        System.out.println("You continue the next fight");
      } else if (input.equals("2")) {
        try {
          SqlDataManagement.writeSqlSaveFile(Player.getHealth(), Player.getScore());
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      } else if (input.equals("3")) {
        try {
          SqlDataManagement.writeSqlSaveFile(Player.getHealth(), Player.getScore());
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
        System.out.println("You exit the dungeon!");
        break;
      }
    }
    System.out.println("Thanks for playing!");
    userInput.close();
  }

}