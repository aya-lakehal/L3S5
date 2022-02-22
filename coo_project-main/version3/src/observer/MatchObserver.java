package observer;

import game.match.Match;

/**
 * An Observer class which has our specific "Match" instead of "Object" (and not "@Deprecated").

 * 
 */
public interface MatchObserver {

	public void update(ObservableMatch arg, Match match);
	
}