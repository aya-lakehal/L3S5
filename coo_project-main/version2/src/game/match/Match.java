package game.match;

import game.competition.Competitor;

/**
 * A class who represent the Match
 */

public interface  Match {
	
	public Competitor theWinner(Competitor c1, Competitor c2);

}