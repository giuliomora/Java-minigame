package strategies;

public class NormalMode implements IBossMode {

	@Override
	public int applyMode(int originalAttack) {
		return originalAttack;
	}
}
