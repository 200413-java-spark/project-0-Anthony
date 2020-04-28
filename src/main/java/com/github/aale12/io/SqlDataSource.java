package com.github.aale12.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDataSource {
  private static SqlDataSource instance;
  private String url;
  private String user;
  private String password;

  private SqlDataSource() {
    url = System.getProperty("database.url", "jdbc:postgresql://@18.219.29.171:5432/mydb");
    user = System.getProperty("database.username", "mydb");
    password = System.getProperty("database.password", "mydb");
  }

  public static SqlDataSource getInstance() {
    if (instance == null) {
      instance = new SqlDataSource();
    }
    return instance;
  }

  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }
}