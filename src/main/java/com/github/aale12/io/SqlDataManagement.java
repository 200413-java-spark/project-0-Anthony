package com.github.aale12.io;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDataManagement {
  private final static String url = "jdbc:postgresql://18.224.107.40:5432/mydb";
  private final static String username = "mydb";
  private final static String password = "mydb";

  public static ResultSet retrieveSqlSaveDataResultSet() throws SQLException {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (java.lang.ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }

    try (Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();) {

      ResultSet result = statement.executeQuery("select * from character");
      while (result.next()) {
        return result;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println("Unable to read save data.");
    return null;
  }

  public static void writeSqlSaveFile(int health, int score, int gold, int potionCt, int lgPotionCt, int smTrinketCt,
      int mdTrinketCt, int lgTrnketCt) throws SQLException {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (java.lang.ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    try (Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();) {
      String query = "UPDATE character" + "SET health = " + health + ", score = " + score + ", gold = " + gold
          + ", potionCt = " + potionCt + ", lgPotionCt = " + lgPotionCt + ", smTrinketCt = " + smTrinketCt
          + ", mdTrinketCt = " + mdTrinketCt + ", lgPotionCt = " + lgPotionCt + " where id=0";
      PreparedStatement ps = connection.prepareStatement(query);
      ps.executeUpdate();
      System.out.println("Attempting to save game data");
    }
  }
}
