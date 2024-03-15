package abilities;

public class TripleAttack extends PlayerDecorator {

	public TripleAttack(IAbilities player) {
		super(player);
	}

	@Override
	public int attack() {
		return super.attack() + super.attack() + super.attack();
	}
}
