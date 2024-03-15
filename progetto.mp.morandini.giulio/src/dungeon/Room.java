package dungeon;

public class Room {

	private final int walls;
	private final int doors;
	private final int spikes;
	private final boolean fog;
	private final boolean boosters;

	private Room(RoomBuilder builder) {
		this.walls = builder.walls;
		this.doors = builder.doors;
		this.spikes = builder.spikes;
		this.fog = builder.fog;
		this.boosters = builder.boosters;
	}

	public static class RoomBuilder {
		private final int walls;
		private final int doors;
		private int spikes;
		private boolean fog;
		private boolean boosters;

		public RoomBuilder() {
			this.walls = 4;
			this.doors = 2;
		}

		public RoomBuilder hasFog() {
			this.fog = true;
			return this;
		}

		public RoomBuilder hasBoosters() {
			this.boosters = true;
			return this;
		}

		public RoomBuilder spikes(int spikes) {
			this.spikes = spikes;
			return this;
		}

		public Room build() {
			Room room = new Room(this);
			return room;
		}
	}

	public int getWalls() {
		return walls;
	}

	public int getDoors() {
		return doors;
	}

	public int getSpikes() {
		return spikes;
	}

	public boolean hasFog() {
		return fog;
	}

	public boolean hasBoosters() {
		return boosters;
	}
}
