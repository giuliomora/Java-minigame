package abilities;

import java.util.Objects;

public abstract class PlayerDecorator implements IAbilities {

	private IAbilities player;

	public PlayerDecorator(IAbilities player) {
		Objects.requireNonNull(player, "Player cannot be null");
		this.player = player;
	}

	@Override
	public int attack() {
		return player.attack();
	}

	@Override
	public void gainStamina() {
		player.gainStamina();
	}
}
