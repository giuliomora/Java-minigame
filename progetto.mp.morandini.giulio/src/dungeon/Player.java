package dungeon;

import abilities.IAbilities;
import observer.IObserver;

public class Player implements IAbilities, IObserver {

	private final String name;
	private int atk;
	private int stamina;
	private int hp;
	private final Boss boss;

	public Player(String name, Boss boss) {
		this.name = name;
		this.atk = 150;
		this.stamina = 5000;
		this.hp = 1000;
		this.boss = boss;
	}

	public int getHp() {
		return hp;
	}

	public int getAtk() {
		return atk;
	}

	public String getName() {
		return name;
	}

	public int getStamina() {
		return stamina;
	}

	@Override
	public void gainStamina() {
		if (stamina <= 4700)
			stamina += 300;
		else
			stamina = 5000;
	}

	@Override
	public int attack() {
		if (hp == 0)
			return 0;
		if (stamina < 300) {
			int lowAttack = stamina;
			stamina = 0;
			return lowAttack;
		} else {
			stamina -= 300;
			return atk * 10;
		}
	}

	@Override
	public void dealDamage() {
		if (hp < boss.getBossAttack())
			this.hp = 0;
		else
			this.hp -= boss.getBossAttack();
	}
}
