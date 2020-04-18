package com.github.aale12.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.github.aale12.game.PlayerCharacter;

public class SaveManagement {
  // write to file
  static File save = new File("Save1.txt");

  public static void createSaveFile(int score) {
    try (FileWriter fileWriter = new FileWriter(save, true);
        BufferedWriter saveWriter = new BufferedWriter(fileWriter);
        PrintWriter savePrinter = new PrintWriter(saveWriter);) {

      savePrinter.println(score);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readSaveFile() {
    try (FileReader fileReader = new FileReader(save); BufferedReader saveReader = new BufferedReader(fileReader);) {
      String line = saveReader.readLine();
      while (line != null) {
        System.out.println(line);
        line = saveReader.readLine();
      }
    } catch (FileNotFoundException err) {
      err.printStackTrace();
    } catch (IOException err) {
      err.printStackTrace();
    }
  }
}