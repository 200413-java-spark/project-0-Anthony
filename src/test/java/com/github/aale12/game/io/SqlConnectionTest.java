package com.github.aale12.game.io;

import java.sql.Statement;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class SqlConnectionTest {
  Connection testConnection;
  ResultSet results;

  @Before
  public void setup() throws SQLException {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (java.lang.ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }

    try (
        Connection connection = DriverManager.getConnection("jdbc:postgresql://18.224.107.40:5432/mydb", "mydb",
            "mydb");
        Statement statement = connection.createStatement();) {
      results = statement.executeQuery("select * from character");
    }
  }

  @Test
  public void characterLoadedTest() throws SQLException {
    assertEquals(0, results.getInt("id"), 0);
  }
}