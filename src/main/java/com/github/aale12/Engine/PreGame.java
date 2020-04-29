package com.github.aale12.Engine;

import java.sql.SQLException;
import com.github.aale12.io.SqlDataManagement;

public class PreGame {
  static String gameData;

  public static void newGamePrompt() {
    System.out.println("No character detected, please enter your name");
    // System.out.println(gameData);
  }

  public static boolean characterStatusCheck() throws SQLException {
    gameData = SqlDataManagement.retrieveSqlSaveDataResultSet();
    // System.out.println("gameData: " + gameData);
    return (gameData.contains("true"));
  }

  public static String loadCharacterData() throws SQLException {
    String output = SqlDataManagement.retrieveSqlSaveDataResultSet();
    return output;
    // if (characterData.next()) {
    // output += characterData.getString("name") + "," +
    // characterData.getInt("health") + ","
    // + characterData.getInt("score") + "," + characterData.getInt("gold") + "," +
    // characterData.getInt("potionCt")
    // + "," + characterData.getInt("lgPotionCt") + "," +
    // characterData.getInt("smTrinketCt") + ","
    // + characterData.getInt("mdTrinketCt") + "," +
    // characterData.getInt("lgTrinketCt");
    // return output;
    // }
  }
}