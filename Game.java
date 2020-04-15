import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    // System Vars
    Scanner userInput = new Scanner(System.in);
    // User Vars
    // int choice = -1;
    // choice = userInput.nextInt();
    int userHp = 100;
    int userAttack = 45;
    // enemy Vars
    int enemyHp = 100;
    int enemyAttack = 1;
    String enemy = "Bandit";

    boolean isRunning = true;
    System.out.println("Welcome!");
    GAME: while (isRunning) {
      System.out.println("================================================");
      enemyHp = 100;
      System.out.println("~ " + enemy + " has appeared! ~\n");

      while (enemyHp > 0) {
        System.out.println("# Your HP: " + userHp + " #");
        System.out.println("# " + enemy + "'s HP: " + enemyHp + " #");
        System.out.println("What to do?");
        System.out.println("1) Attack");
        System.out.println("2) Run");

        String input = userInput.nextLine();
        if (input.equals("1")) {
          // int damageDealt = userAttack;
          // int damageTaken = enemyAttack;
          enemyHp -= userAttack;
          userHp -= enemyAttack;
          System.out.println("> You attack the " + enemy + " for " + userAttack + " damage!");
          System.out.println("> You recieve " + enemyAttack + " damage!");

          if (userHp <= 0) {
            System.out.println("> You have died!");
            break;
          }
        } else if (input.equals("2")) {
          System.out.println("You ran away...into another Bandit!");
          enemyHp = 100;
          continue GAME;
        } else {
          System.out.println("Invalid Command!");
        }
      }
      // when you die
      if (userHp <= 0) {
        System.out.println("Game Over!");
        break;
      }
      // if enemy defeated
      System.out.println("================================================");
      System.out.println(enemy + " was defeated!");
      System.out.println("You heal your wounds.");
      userHp = 100;
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
  }
}