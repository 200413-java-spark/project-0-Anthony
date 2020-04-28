package com.github.aale12.game;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.github.aale12.io.SaveManagement;
import com.github.aale12.io.SqlDataManagement;

public class Engine {
  public static void run() {
    String[] localFile;
    Scanner userInput = new Scanner(System.in);
    final PlayerCharacter Player = new PlayerCharacter(100, 45, "Alex", 0);
    final NonPlayerCharacter Enemy = new NonPlayerCharacter(100, 1, "Bandit");

    boolean isRunning = true;
    GAME: while (isRunning) {
      try {
        SqlDataManagement.testData();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      System.out.println("================================================");
      try {
        SaveManagement.readSaveFile();
        String saveFile = SaveManagement.readSaveFile();
        localFile = saveFile.split(",");
        Player.setHp(Integer.parseInt(localFile[0]));
        Player.setScore(Integer.parseInt(localFile[1]));
      } catch (NoSuchElementException e) {
        SaveManagement.writeSaveFile(Player.getHp(), Player.getScore());
        try {
          SqlDataManagement.writeSqlSaveFile(Player.getHp(), Player.getScore());
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
      Enemy.setHp(100);
      System.out.println("~ " + Enemy.getName() + " has appeared! ~\n");

      while (Enemy.getHp() > 0) {
        System.out.println("# Your HP: " + Player.getHp() + " #");
        System.out.println("# " + Enemy.getName() + "'s HP: " + Enemy.getHp() + " #");
        System.out.println("Current Score: " + Player.getScore());
        System.out.println("What to do?");
        System.out.println("1) Attack");
        System.out.println("2) Run");

        String input = userInput.nextLine();
        if (input.equals("1")) {
          // int damageDealt = userAttack;
          // int damageTaken = enemyAttack;
          Enemy.setHp(Enemy.getHp() - Player.getAttack());
          Player.setHp(Player.getHp() - Enemy.getAttack());
          System.out.println("> You attack the " + Enemy.getName() + " for " + Player.getAttack() + " damage!");
          System.out.println("> You recieve " + Enemy.getAttack() + " damage!");
          // System.out.println("\tDebug: Enemy HP: " + Enemy.getHp() + "\n \t Player HP:
          // " + Player.getHp());

          if (Player.getHp() <= 0) {
            System.out.println("> You have died!");
            break;
          }
        } else if (input.equals("2")) {
          System.out.println("You ran away...into another Enemy!");
          Enemy.setHp(100);
          continue GAME;
        } else {
          System.out.println("Invalid Command!");
        }
      }
      // when you die
      if (Player.getHp() <= 0) {
        Player.setScore(0);
        System.out.println("Game Over!");
        break;
      }
      // if enemy defeated
      Player.increaseScore();
      System.out.println("================================================");
      System.out.println(Enemy.getName() + " was defeated!\n Your Score: " + Player.getScore());
      // System.out.println("You heal your wounds.");
      // Player.setHp(100);
      System.out.println("================================================");
      System.out.println("1) Continue Fighting");
      System.out.println("2) Save");
      System.out.println("3) Exit");

      String input = userInput.nextLine();

      while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
        System.out.println("Invalid Command");
        input = userInput.nextLine();
      }
      if (input.equals("1")) {
        System.out.println("You continue the next fight");
      } else if (input.equals("2")) {
        try {
          SqlDataManagement.writeSqlSaveFile(Player.getHp(), Player.getScore());
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
        SaveManagement.writeSaveFile(Player.getHp(), Player.getScore());
      } else if (input.equals("3")) {
        System.out.println("You exit the dungeon!");
        break;
      }
    }
    System.out.println("Thanks for playing!");
    userInput.close();
  }

}