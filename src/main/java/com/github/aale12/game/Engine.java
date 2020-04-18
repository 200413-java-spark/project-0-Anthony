package com.github.aale12.game;

import java.util.Scanner;

import com.github.aale12.io.SaveManagement;

public class Engine {
  public static void run() {
    Scanner userInput = new Scanner(System.in);
    final PlayerCharacter Player = new PlayerCharacter(100, 45, "You", 0);
    final NonPlayerCharacter Enemy = new NonPlayerCharacter(100, 1, "Bandit");

    boolean isRunning = true;
    GAME: while (isRunning) {
      System.out.println("================================================");
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
      SaveManagement.createSaveFile(Player.getScore());
      System.out.println("================================================");
      System.out.println(Enemy.getName() + " was defeated!\n Your Score: " + Player.getScore());
      System.out.println("You heal your wounds.");
      Player.setHp(100);
      System.out.println("================================================");
      System.out.println("1) Continue Fighting");
      System.out.println("2) Exit");

      String input = userInput.nextLine();

      while (!input.equals("1") && !input.equals("2")) {
        System.out.println("Invalid Command");
        input = userInput.nextLine();
      }
      if (input.equals("1")) {
        System.out.println("You continue the next fight");
      } else if (input.equals("2")) {
        System.out.println("You exit the dungeon!");
        break;
      }
    }
    System.out.println("Thanks for playing!");
    userInput.close();
  }
}