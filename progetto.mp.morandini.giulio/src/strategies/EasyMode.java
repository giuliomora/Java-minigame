package strategies;

public class EasyMode implements IBossMode {

	@Override
	public int applyMode(int originalAttack) {
		return originalAttack / 2;
	}
}
