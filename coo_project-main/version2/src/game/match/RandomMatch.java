package game.match;
import java.util.Random;

import game.competition.Competitor;

/**
 * A class who represent the Match
 */

public class RandomMatch implements Match {
	/**
	 * *method to return the winner of the match
	 * *@return the winner of the match
	 * */
	
	public Competitor theWinner(Competitor c1, Competitor c2) {
		Random num = new Random();
		int win = num.nextInt(2);
		if(win == 0 ) {
			return c1;
		}
		else {
			return c2;
		}
	}
}
