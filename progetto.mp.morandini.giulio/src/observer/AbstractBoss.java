package observer;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractBoss {

	private Collection<IObserver> observers = new ArrayList<>();

	public void attach(IObserver observer) {
		observers.add(observer);
	}

	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		observers.forEach(IObserver::dealDamage);
	}

}