package dungeon;

public class Dungeon {

	private final Player p1;
	private final Player p2;
	private final Player p3;
	private final Player p4;
	private final Boss boss;
	private final Room room;
	private int turnNumber;

	public Dungeon(Player p1, Player p2, Player p3, Player p4, Boss boss, Room room) {
		this.p1 = p1;
		boss.attach(p1);
		this.p2 = p2;
		boss.attach(p2);
		this.p3 = p3;
		boss.attach(p3);
		this.p4 = p4;
		boss.attach(p4);
		this.boss = boss;
		this.room = room;
		this.turnNumber = 0;
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	public Player getP1() {
		return p1;
	}

	public Player getP2() {
		return p2;
	}

	public Player getP3() {
		return p3;
	}

	public Player getP4() {
		return p4;
	}

	public Boss getBoss() {
		return boss;
	}

	public Room getRoom() {
		return room;
	}

	private int realAttack(Player p) {
		if (room.hasBoosters())
			return p.attack() + 100;
		else
			return p.attack();
	}

	private boolean areAllKo() {
		if (p1.getHp() == 0 && p2.getHp() == 0 && p3.getHp() == 0 && p4.getHp() == 0)
			return true;
		else
			return false;
	}

	public String turn() {
		if (areAllKo())
			return "Il team è stato sconfitto, hai perso";
		if (boss.getHp() == 0)
			return "Il Boss ha 0 Hp, è stato sconfitto";
		else {
			boss.dealDamageBoss(realAttack(p1));
			boss.dealDamageBoss(realAttack(p2));
			boss.dealDamageBoss(realAttack(p3));
			boss.dealDamageBoss(realAttack(p4));
			boss.bossAttacks();
			turnNumber++;
			return p1.getName() + " ha attaccato, " + p2.getName() + " ha attaccato, " + p3.getName()
					+ " ha attaccato, " + p4.getName() + " ha attaccato, il Boss ha attaccato.";
		}
	}

	public String softTurn() {
		if (areAllKo())
			return "Il team è stato sconfitto, hai perso";
		if (boss.getHp() == 0)
			return "Il Boss ha 0 Hp, è stato sconfitto";
		else {
			boss.dealDamageBoss(realAttack(p1));
			boss.dealDamageBoss(realAttack(p2));
			boss.bossAttacks();
			turnNumber++;
			return p1.getName() + " ha attaccato, " + p2.getName() + " ha attaccato, il Boss ha attaccato.";
		}
	}
}
