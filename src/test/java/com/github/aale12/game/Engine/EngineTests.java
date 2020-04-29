package com.github.aale12.game.Engine;

import static org.junit.Assert.assertEquals;

import com.github.aale12.Engine.Combat;
import com.github.aale12.Engine.PostCombat;
import com.github.aale12.game.NonPlayerCharacter;
import com.github.aale12.game.PlayerCharacter;

import org.junit.Before;
import org.junit.Test;

public class EngineTests {
  PlayerCharacter Player = new PlayerCharacter(10, "Bill", 100, 0, 0, 0, 0, 0, 0, 0);
  NonPlayerCharacter Enemy = Combat.createEnemy();

  @Before
  public void testBattleSetup(PlayerCharacter Player, NonPlayerCharacter Enemy) {
    Combat.PlayerAttack(Player, Enemy);
    PostCombat.awardTrinket(Player, Enemy);
  }

  @Test
  public void trinketDropTest() {
    assertEquals(1, Player.getSmTrinketCt());
  }
}