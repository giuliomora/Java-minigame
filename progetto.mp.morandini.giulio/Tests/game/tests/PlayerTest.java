package game.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abilities.Booster;
import abilities.Clever;
import abilities.IAbilities;
import abilities.TripleAttack;
import dungeon.Boss;
import dungeon.Player;
import strategies.EasyMode;
import strategies.HardMode;
import strategies.NormalMode;

public class PlayerTest {

	Boss boss = new Boss();
	Player p1 = new Player("Pino", boss);
	Player p2 = new Player("Attacker", boss);
	Player p3 = new Player("Clever", boss);
	Player p4 = new Player("Wall", boss);

	@Test
	public void playerTest() {
		assertEquals(150, p1.getAtk());
		assertEquals(5000, p1.getStamina());
		assertEquals(1000, p1.getHp());

		p1.gainStamina();
		assertEquals(5000, p1.getStamina());
		assertEquals(1500, p1.attack());
		assertEquals(4700, p1.getStamina());
		for (int i = 0; i < 13; i++)
			p1.attack();
		assertEquals(800, p1.getStamina());
		assertEquals(1500, p1.attack());
		p1.attack();
		assertEquals(200, p1.getStamina());
		assertEquals(200, p1.attack());
		assertEquals(0, p1.getStamina());
		assertEquals(0, p1.attack());
	}

	@Test
	public void decoratorTest() {
		IAbilities attacker = new Booster(p2);
		assertEquals(5000, p2.getStamina());
		assertEquals(2500, attacker.attack());
		assertEquals(4700, p2.getStamina());

		IAbilities clever = new Clever(p3);
		assertEquals(5000, p3.getStamina());
		assertEquals(1500, clever.attack());
		assertEquals(4700, p3.getStamina());
		clever.attack();
		assertEquals(4700, p3.getStamina());
		clever.attack();
		assertEquals(4700, p3.getStamina());

		IAbilities tripleAttacker = new TripleAttack(p4);
		assertEquals(4500, tripleAttacker.attack());
		assertEquals(4100, p4.getStamina());
		tripleAttacker.attack();
		tripleAttacker.attack();
		tripleAttacker.attack();
		assertEquals(1400, p4.getStamina());
		assertEquals(4500, tripleAttacker.attack());
		tripleAttacker.attack();
		assertEquals(0, p4.getStamina());
		assertEquals(0, tripleAttacker.attack());
	}

	@Test
	public void zeroHpTest() {
		boss.attach(p1);
		boss.changeMode(new HardMode());
		boss.bossAttacks();
		boss.bossAttacks();
		boss.bossAttacks();
		boss.bossAttacks();
		boss.changeMode(new EasyMode());
		boss.bossAttacks();
		boss.bossAttacks();
		boss.bossAttacks();
		assertEquals(50, p1.getHp());
		boss.changeMode(new NormalMode());
		boss.bossAttacks();
		assertEquals(0, p1.getHp());
		assertEquals(0, p1.attack());
	}
}
