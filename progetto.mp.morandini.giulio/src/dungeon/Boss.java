package dungeon;

import observer.AbstractBoss;
import strategies.IBossMode;
import strategies.NormalMode;

public class Boss extends AbstractBoss {

	private int bossHp;
	private int bossAttack;
	private IBossMode mode;

	public Boss() {
		super();
		this.bossHp = 10000;
		this.bossAttack = 100;
		this.mode = new NormalMode();
	}

	public int getBossAttack() {
		return mode.applyMode(bossAttack);
	}

	public int getHp() {
		return bossHp;
	}

	public IBossMode getMode() {
		return mode;
	}

	public void changeMode(IBossMode mode) {
		this.mode = mode;
	}

	public void dealDamageBoss(int damage) {
		if (this.bossHp <= damage)
			this.bossHp = 0;
		else
			this.bossHp -= damage;
	}

	public void bossAttacks() {
		if (bossHp != 0)
			notifyObservers();
	}
}
