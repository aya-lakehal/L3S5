
package game;

import java.util.*;

public abstract class Competition {
	
	protected final List<Competitor> competitors;
	protected Match match;
	  /**
	  *the constructor of this class
	  *@param  competitors a list of competitors 
	  *@param  match will be played by competitors 
	  */
	public Competition(List<Competitor> competitors, Match match) {
		this.competitors = competitors;	
		this.match = match;
	}
	/**
	 * *a method to play 
	 */	
	public void play() {
		play(this.competitors);
		ranking();
	}
	/**
	 * *a method to play 
	 * *@param competitors a list of competitors 
	 * */
	protected  void play(List<Competitor> competitors) {
		
	}
	/**
	 * *a method to play a match
	 * *@param c1 competitor who play this match
	 * *@param c2 the second competitor who play this match
	 * */
	protected abstract void playMatch(Competitor c1, Competitor c2);
	
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
	

}
