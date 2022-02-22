
package game;
import java.util.List;

/**
 * A class which simulate a league with random match
 * 
 */
public class League extends Competition {
	
	

	/**
	 * Constructor of League
	 * @param competitors List of Competitor
	 */

	  public League(List<Competitor> competitors,Match match) {
		  super(competitors,match);
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
	  /**
	   * *a method to play a match
	   * *@param c1 competitor who play this match
	   * *@param c2 the second competitor who play this match
	   * */
	  public void playMatch(Competitor c1, Competitor c2) {
		  Competitor gagnant = this.match.theWinner(c1, c2);
		  gagnant.increaseNbPoints(1);
		  System.out.println(c1.getName()+" vs "+c2.getName()+" --> "+gagnant.getName()+" wins! ");
	  }

}
	  
