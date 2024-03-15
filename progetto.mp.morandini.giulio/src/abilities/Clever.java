package abilities;

public class Clever extends PlayerDecorator {

	public Clever(IAbilities player) {
		super(player);
	}

	@Override
	public int attack() {
		super.gainStamina();
		return super.attack();
	}
}
