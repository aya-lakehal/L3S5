
package game.competition;
import java.util.*;

import displayer.Displayer;
import exception.NumberOfCompetitorException;
import game.match.Match;
import utils.MapUtil;

public abstract class Competition {
	
	protected Displayer displayer;
	
	protected final List<Competitor> competitors;
	protected Match match;
	  /**
	  *the constructor of this class
	  *@param  competitors a list of competitors 
	  *@param  match will be played by competitors 
	  */
	public Competition(List<Competitor> competitors, Match match,Displayer displayer) {
		this.competitors = competitors;	
		this.match = match;
		this.displayer = displayer;
	}
	/**
	 * *a method to play 
	 * @throws NumberOfCompetitorException 
	 */	
	public void play() throws NumberOfCompetitorException {
		play(this.competitors);
		ranking();
	}
	/**
	 * *a method to play 
	 * *@param competitors a list of competitors 
	 * @throws NumberOfCompetitorException 
	 * */
	protected  void play(List<Competitor> competitors) throws NumberOfCompetitorException {
		
	}
	/**
	 * *a method to play a match
	 * *@param c1 competitor who play this match
	 * *@param c2 the second competitor who play this match
	 * */
	protected void playMatch(Competitor c1, Competitor c2) {
		Competitor gagnant = this.match.theWinner(c1, c2);
		gagnant.increaseNbPoints(1);
		this.displayer.message(c1.getName()+" vs "+c2.getName()+" --> "+gagnant.getName()+" wins! ");
	}
	
	/**
	 * *a method to classified the competitors 
	 * *@return map associate a competitor with his or her points 
	 * */
	
	public Map<Competitor,Integer> ranking() {
		
		Map<Competitor,Integer> competite = new HashMap<>();
		for(Competitor c1 : this.competitors ) {
			competite.put(c1, c1.getPoints());
		}
		return MapUtil.sortByDescendingValue(competite);
	}
	
	public Competitor theOfficialWinner() {
		Competitor winner;
        winner = (Competitor) this.ranking().keySet().toArray()[0];
        return winner;
	}
	

}
