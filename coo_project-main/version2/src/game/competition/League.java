package game.competition;


import java.util.List;

import displayer.Displayer;
import game.match.Match;

/**
 * A class which simulate a league with random match
 * 
 */
public class League extends Competition {
	
	

	/**
	 * Constructor of League
	 * @param competitors List of Competitor
	 */

	  public League(List<Competitor> competitors,Match match,Displayer displayer) {
		  super(competitors,match, displayer);
	  }
	  
	  public void play(List<Competitor> competitors) {
		  for (Competitor c1 : competitors) {
			  for (Competitor c2 : competitors) {
				  if (c1 != c2) {
					  playMatch(c1, c2);
				  }
			  }
		  }
	  }	

}
	  
