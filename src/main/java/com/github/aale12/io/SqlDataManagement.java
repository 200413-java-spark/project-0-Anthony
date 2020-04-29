package com.github.aale12.io;

import java.sql.Statement;

import com.github.aale12.game.PlayerCharacter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDataManagement {
  private final static String url = "jdbc:postgresql://18.224.107.40:5432/mydb";
  private final static String username = "mydb";
  private final static String password = "mydb";

  public static String retrieveSqlSaveDataResultSet() throws SQLException {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (java.lang.ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }

    try (Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();) {

      ResultSet result = statement.executeQuery("select * from character");
      while (result.next()) {
        return result.getBoolean("isAlive") + "," + result.getString("charname") + "," + result.getInt("health") + ","
            + result.getInt("score") + "," + result.getInt("gold") + "," + result.getInt("potionCt") + ","
            + result.getInt("lgPotionCt") + "," + result.getInt("smTrinketCt") + "," + result.getInt("mdTrinketCt")
            + "," + result.getInt("lgTrinketCt");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return "Unable to read save data.";

  }

  public static void writeSqlSaveFile(String name, int health, int score, int gold, int potionCt, int lgPotionCt,
      int smTrinketCt, int mdTrinketCt, int lgTrinketCt) throws SQLException {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (java.lang.ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    try (Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();) {
      String query = "UPDATE character SET charname = " + "'" + name + "'" + ", health = " + health + ", score = "
          + score + ", gold = " + gold + ", potionCt = " + potionCt + ", lgPotionCt = " + lgPotionCt
          + ", smTrinketCt = " + smTrinketCt + ", mdTrinketCt = " + mdTrinketCt + ", lgTrinketCt = " + lgTrinketCt
          + " where id=0";
      PreparedStatement ps = connection.prepareStatement(query);
      ps.executeUpdate();
      System.out.println("Attempting to save game data");
    }
  }

  public static void saveGameSql(PlayerCharacter Player) {
    try {
      SqlDataManagement.writeSqlSaveFile(Player.getName(), Player.getHealth(), Player.getScore(), Player.getGold(),
          Player.getPotionCt(), Player.getLgPotionCt(), Player.getSmTrinketCt(), Player.getMdTrinketCt(),
          Player.getLgTrinketCt());
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
  }

  public static void setSqlCharacterStatus(boolean status) throws SQLException {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (java.lang.ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    try (Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();) {
      String query = "UPDATE character SET isAlive = " + status + " where id=0";
      PreparedStatement ps = connection.prepareStatement(query);
      ps.executeUpdate();
      // System.out.println("Setting Character alive status: " + status);
    }
  }
}
