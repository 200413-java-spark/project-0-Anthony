package com.github.aale12.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveManagement {
  // write to file
  static File save = new File("Save1.csv");

  public static void writeSaveFile(int Hp, int score) {
    try (FileWriter fileWriter = new FileWriter(save, true);
        BufferedWriter saveWriter = new BufferedWriter(fileWriter);
        PrintWriter savePrinter = new PrintWriter(saveWriter);) {
      savePrinter.println(Hp + "," + score);
      System.out.println("Game Saved!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String readSaveFile() {
    String line;
    String last = "100,0";
    try (FileReader fileReader = new FileReader(save); BufferedReader saveReader = new BufferedReader(fileReader);) {
      while ((line = saveReader.readLine()) != null) {
        last = line;
      }
      // System.out.println("Last line read: " + last);
      return last;
    } catch (FileNotFoundException err) {
      err.printStackTrace();
    } catch (IOException err) {
      err.printStackTrace();
    }
    System.out.println("Unable to read save file.");
    return last;
  }
}