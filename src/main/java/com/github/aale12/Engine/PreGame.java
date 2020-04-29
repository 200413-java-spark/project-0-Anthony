package com.github.aale12.Engine;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.github.aale12.io.SqlDataManagement;

public class PreGame {
  public static void newGamePrompt() {
    System.out.println("No character detected, please enter your name");
  }

  public static boolean characterStatusCheck() throws SQLException {
    // ResultSet gameData = SqlDataManagement.retrieveSqlSaveDataResultSet();
    return SqlDataManagement.retrieveSqlSaveDataResultSet().getBoolean("isAlive");
  }

  public static String loadCharacterData() throws SQLException {
    ResultSet characterData = SqlDataManagement.retrieveSqlSaveDataResultSet();
    String output = "";
    if (characterData.next()) {
      output += characterData.getString("name") + "," + characterData.getInt("health") + ","
          + characterData.getInt("score") + "," + characterData.getInt("gold") + "," + characterData.getInt("potionCt")
          + "," + characterData.getInt("lgPotionCt") + "," + characterData.getInt("smTrinketCt") + ","
          + characterData.getInt("mdTrinketCt") + "," + characterData.getInt("lgTrinketCt");
      return output;
    }
    return "Unable to load character data, output is: " + output;
  }
}