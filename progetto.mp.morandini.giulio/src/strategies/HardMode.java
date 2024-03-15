package strategies;

public class HardMode implements IBossMode {

	@Override
	public int applyMode(int originalAttack) {
		return originalAttack * 2;
	}
}
