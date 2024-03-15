package game.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dungeon.Room;

public class RoomTest {

	Room r1 = new Room.RoomBuilder().build();
	Room r2 = new Room.RoomBuilder().hasBoosters().hasFog().spikes(100).build();

	@Test
	public void builderTest() {
		assertEquals(0, r1.getSpikes());
		assertEquals(4, r1.getWalls());
		assertEquals(2, r1.getDoors());
		assertFalse(r1.hasBoosters());
		assertFalse(r1.hasFog());

		assertTrue(r2.hasBoosters());
		assertTrue(r2.hasFog());
		assertEquals(100, r2.getSpikes());
	}
}
