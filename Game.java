import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    Random rand = new Random();
    int choice = -1;
    printMenu();
    choice = userInput.nextInt();
    boolean isRunning = true;
    System.out.println("Welcome!");
    GAME:
    while(running){
      System.out.println("================================================");
      int enemyHP = rand.nextInt(100); //max hp for enemies
      String enemy = "Bandit";
      System.out.println("~ " + enemy + " has appeared! ~\n");

        while (enemyHP > 0) {
          System.out.println("# Your HP: " + ");
        }
    }
  }

  public static void printMenu() {
    System.out.println("Please select one of the following:\n" + "1) New Game\n" + "2) Continue\n" + "3) Exit");
  }

  public static void gameMenu() {
    System.out.println("Actions:\n" + "1) Fight\n" + "2) Store\n" + "3) Items\n" + "4) Exit");
  }
}