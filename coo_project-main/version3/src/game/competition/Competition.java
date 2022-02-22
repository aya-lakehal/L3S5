
package game.competition;
import java.util.*;



import exception.NumberOfCompetitorException;
import game.match.Match;
import game.match.RandomMatch;
import utils.MapUtil;
import observer.ObservableMatch;

public abstract class Competition {
	
;	
	protected final List<Competitor> competitors;
	protected Match match;
	protected final Map<Competitor, Integer> rankings;
	  /**
	  *the constructor of this class
	  *@param  competitors a list of competitors 
	  *@param  match will be played by competitors 
	  */
	
	public Competition(final List<Competitor> competitors) {
		this(competitors, new RandomMatch());
	}
	public Competition(List<Competitor> competitors, Match match) {
		this.competitors = competitors;	
		this.match = match;
		this.rankings = new HashMap<Competitor, Integer>();
		for (Competitor competitor : competitors) {
			rankings.put(competitor, 0);
	    }
	}
	/**
	 * *a method to play 
	 * @throws NumberOfCompetitorException 
	 */	
	public void play() throws NumberOfCompetitorException {
		play(competitors);
		ranking();
	}
	/**
	 * *a method to play 
	 * *@param competitors a list of competitors 
	 * @throws NumberOfCompetitorException 
	 * */
	protected abstract void play(List<Competitor> cps);
	/**
	 * *a method to play a match
	 * *@param c1 competitor who play this match
	 * *@param c2 the second competitor who play this match
	 * */
	
	
	
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
	
	public Competitor theOfficialWinner() {
		Competitor winner;
        winner = (Competitor) this.ranking().keySet().toArray()[0];
        return winner;
	}
	
	public int getNbPlayers() {
		return competitors.size();
	}

	protected Match getMatch() {
		return match;
	}
	public void addPointToCompetitor(Competitor competitor) {
		rankings.compute(competitor, (k, v) -> v + 1);
	}


}
