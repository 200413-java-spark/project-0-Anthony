package com.github.aale12.Engine;

import java.sql.SQLException;

import com.github.aale12.game.NonPlayerCharacter;
import com.github.aale12.game.PlayerCharacter;
import com.github.aale12.io.SqlDataManagement;

public class DecisionFactory {
  public static void decisionPreCombat(String input, PlayerCharacter Player, NonPlayerCharacter Enemy) {
    switch (input) {
      case "1":
        Combat.BattleStart(Player, Enemy);
        break;
      case "2":
        break;
      case "3":
        try {
          SqlDataManagement.writeSqlSaveFile(Player.getName(), Player.getHealth(), Player.getScore(), Player.getGold(),
              Player.getPotionCt(), Player.getLgPotionCt(), Player.getSmTrinketCt(), Player.getMdTrinketCt(),
              Player.getLgTrinketCt());
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
        break;
      case "4":
        try {
          SqlDataManagement.writeSqlSaveFile(Player.getName(), Player.getHealth(), Player.getScore(), Player.getGold(),
              Player.getPotionCt(), Player.getLgPotionCt(), Player.getSmTrinketCt(), Player.getMdTrinketCt(),
              Player.getLgTrinketCt());
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
        System.out.println("You exit the dungeon!");
        break;
    }
  }
}