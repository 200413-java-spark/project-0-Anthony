package com.github.aale12;

import java.io.IOException;

import com.github.aale12.Engine.Engine;

public final class Game {
  public void play() throws IOException {
    System.out.println("Welcome to Anthony's Game!!!");
    Engine.run();
  }

  public static void main(String[] args) throws IOException {
    Game game = new Game();
    game.play();
  }
}