package abilities;

public class Booster extends PlayerDecorator {

	public Booster(IAbilities player) {
		super(player);
	}

	@Override
	public int attack() {
		return super.attack() + 1000;
	}
}
