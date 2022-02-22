package game.competition;
import java.util.ArrayList;
import java.util.List;
import game.match.Match;

public class Tournament extends Competition {
	/**
	*the constructor of this class
	*@param competitors the list competitors of this tournament
	*@param match the match which the competitor will play
	*/
	public Tournament(List<Competitor> competitors,Match match){
		super(competitors,match);
		
	}

	/**
	 * *a method to play a match
	 * * *@param c1 competitor who play this match
	 * *@param c2 the second competitor who play this match
	 * */	
	public void play(List<Competitor> competitors) {
		List<Competitor> competitorCopy = new ArrayList<Competitor>();
		competitorCopy.addAll(competitors);
		List<Competitor> winnerCompetitor = new ArrayList<Competitor>();
		
		while (competitorCopy.size() != 1) {
			for(int i=0 ; i < competitorCopy.size() ; i+=2) {
				Competitor c1 = competitorCopy.get(i);
				Competitor c2 = competitorCopy.get(i+1);
				playMatch(c1 ,c2);
				competitorCopy.remove(c1);
				competitorCopy.remove(c2);
				if (c1.getPoints() > c2.getPoints()) {
					winnerCompetitor.add(c1);
				}
				else {
					winnerCompetitor.add(c2);
				}		
			}
			competitorCopy.addAll(winnerCompetitor);
		    winnerCompetitor = new ArrayList<Competitor>();
		}
	}
	
	public boolean powerOfTwo(List<Competitor> competitors) {
		double result;
		result = Math.log(competitors.size()) / Math.log(2);
		return (int) result == result;
	}


	@Override
	protected void playMatch(Competitor c1, Competitor c2) {

		getMatch().clearCompetitor();
		getMatch().addCompetitor(c1);
		getMatch().addCompetitor(c2);
		Competitor winnerCompetitor = getMatch().playMatch();
		addPointToCompetitor(winnerCompetitor);
		//setChanged();
		//notifyObservers(getMatch());
		System.out.printf("%s vs %s --> %s wins!\n", c1.getName(), c2.getName(), winnerCompetitor.getName());
		//this.nextPhase.add(winnerCompetitor);
	}

}