package com.github.aale12;

import java.io.IOException;
import java.sql.SQLException;

import com.github.aale12.Engine.Engine;

public final class Game {
<<<<<<< HEAD
  public void play() throws IOException {
    System.out.println("Welcome to Anthony's Game!!!");
=======
  public void play() throws IOException, NumberFormatException, SQLException {
    System.out.println("####################################################################");
    System.out.println("#      _                   __          __             _            #");
    System.out.println("#     | |                  \\ \\        / /            (_)           #");
    System.out.println("#     | | __ ___   ____ _   \\ \\  /\\  / /_ _ _ __ _ __ _  ___  _ __ #");
    System.out.println("# _   | |/ _` \\ \\ / / _` |   \\ \\/  \\/ / _` | '__| '__| |/ _ \\| '__|#");
    System.out.println("#| |__| | (_| |\\ V / (_| |    \\  /\\  / (_| | |  | |  | | (_) | |   #");
    System.out.println("# \\____/ \\__,_| \\_/ \\__,_|     \\/  \\/ \\__,_|_|  |_|  |_|\\___/|_|   #");
    System.out.println("####################################################################");
>>>>>>> dev
    Engine.run();
  }

  public static void main(String[] args) throws IOException, NumberFormatException, SQLException {
    Game game = new Game();
    game.play();
  }
}