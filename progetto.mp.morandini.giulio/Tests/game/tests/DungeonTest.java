package game.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dungeon.Boss;
import dungeon.Dungeon;
import dungeon.Player;
import dungeon.Room;
import strategies.HardMode;

public class DungeonTest {

	private final Boss boss = new Boss();
	private final Player p1 = new Player("Mattia", boss);
	private final Player p2 = new Player("Silvio", boss);
	private final Player p3 = new Player("Ettore", boss);
	private final Player p4 = new Player("Pietro", boss);
	private final Room room = new Room.RoomBuilder().hasBoosters().hasFog().spikes(100).build();
	private final Dungeon dungeon = new Dungeon(p1, p2, p3, p4, boss, room);

	@Test
	public void dungeonTest() {
		boss.changeMode(new HardMode());
		assertEquals(
				"Mattia ha attaccato, Silvio ha attaccato, Ettore ha attaccato, Pietro ha attaccato, il Boss ha attaccato.",
				dungeon.turn());
		assertEquals(3600, boss.getHp());
		assertEquals(800, p1.getHp());
		assertEquals("Mattia ha attaccato, Silvio ha attaccato, il Boss ha attaccato.", dungeon.softTurn());
		assertEquals(400, boss.getHp());
		assertEquals(600, p1.getHp());
		assertEquals(2, dungeon.getTurnNumber());
		dungeon.turn();
		assertEquals(0, boss.getHp());
		assertEquals(600, p1.getHp());
		assertEquals(3, dungeon.getTurnNumber());
		assertEquals("Il Boss ha 0 Hp, è stato sconfitto", dungeon.turn());
		assertEquals("Il Boss ha 0 Hp, è stato sconfitto", dungeon.softTurn());
		assertEquals(600, p1.getHp());
		assertEquals(3, dungeon.getTurnNumber());
	}
	
	@Test
	public void defeatTest() {
		boss.changeMode(new HardMode());
		for (int i=0; i<5; i++) boss.bossAttacks();
		assertEquals(0, p1.getHp());
		assertEquals("Il team è stato sconfitto, hai perso", dungeon.turn());
		assertEquals("Il team è stato sconfitto, hai perso", dungeon.softTurn());
		assertEquals(0, dungeon.getTurnNumber());
	}
}
