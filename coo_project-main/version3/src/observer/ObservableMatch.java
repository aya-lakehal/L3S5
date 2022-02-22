package observer;

import java.util.Collection;
import java.util.HashSet;

import game.match.Match;

/**
 * An Observable class which has our specific "Match" instead of "Object" (and not "@Deprecated").
 * 
 */
public class ObservableMatch {

	private Collection<MatchObserver> observers = new HashSet<MatchObserver>();
	
	public void addObserver(MatchObserver observer) {
		observers.add(observer);
	}
	
	public void deleteObserver(MatchObserver observer) {
		observers.remove(observer);
	}
	
	public void deleteObservers() {
		observers.clear();
	}
	
	public int countObservers() {
		return observers.size();
	}

	public void notifyObservers(Match match) {
		for (MatchObserver observer : observers) {
			observer.update(this, match);
		}
	}
}
