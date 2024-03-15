package game.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abilities.Clever;
import abilities.IAbilities;
import dungeon.Boss;
import dungeon.Player;
import strategies.EasyMode;
import strategies.HardMode;
import strategies.NormalMode;

public class BossTest {
	Boss boss = new Boss();
	Player p1 = new Player("Gigi", boss);
	Player p2 = new Player("Marco", boss);

	@Test
	public void bossTest() {
		IAbilities clever = new Clever(p1);
		assertEquals(10000, boss.getHp());
		boss.dealDamageBoss(clever.attack());
		assertEquals(8500, boss.getHp());
		for (int i = 0; i < 5; i++)
			boss.dealDamageBoss(clever.attack());
		assertEquals(1000, boss.getHp());
		boss.dealDamageBoss(clever.attack());
		assertEquals(0, boss.getHp());
		assertEquals(4700, p1.getStamina());
	}

	@Test
	public void observerTest() {
		boss.attach(p1);
		boss.attach(p2);
		boss.bossAttacks();
		assertEquals(900, p1.getHp());
		assertEquals(900, p2.getHp());
		boss.detach(p2);
		boss.bossAttacks();
		assertEquals(800, p1.getHp());
		assertEquals(900, p2.getHp());
	}

	@Test
	public void strategyTest() {
		assertEquals(100, boss.getBossAttack());
		boss.changeMode(new EasyMode());
		assertEquals(50, boss.getBossAttack());
		boss.changeMode(new HardMode());
		assertEquals(200, boss.getBossAttack());
		boss.changeMode(new NormalMode());
		assertEquals(100, boss.getBossAttack());
	}
}
