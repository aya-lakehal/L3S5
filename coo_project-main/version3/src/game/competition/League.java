package game.competition;

import java.util.List;

import game.match.Match;


/**
 *  
 */
public class League extends Competition {

	/**
	 * Constructor of League
	 * @param competitors List of Competitor
	 */
	public League(List<Competitor> competitors) {
		super(competitors);
	}
	
	/**
	 * Constructor of League
	 * @param competitors List of Competitor
	 * @param match Match
	 */
	public League(List<Competitor> competitors, Match match) {
		super(competitors, match);
	}

	@Override
	protected void play(List<Competitor> cps) {
		for (Competitor c1 : cps) {
			for (Competitor c2 : cps) {
				if (c1 != c2) {
					playMatch(c1, c2);
				}
			}
		}
	}

	@Override
	protected void playMatch(Competitor c1, Competitor c2) {
		getMatch().clearCompetitor();
		getMatch().addCompetitor(c1);
		getMatch().addCompetitor(c2);
		Competitor winnerCompetitor = getMatch().playMatch();
		addPointToCompetitor(winnerCompetitor);
		//notifyObservers(getMatch());
		System.out.printf("%s vs %s --> %s wins!\n", c1.getName(), c2.getName(), winnerCompetitor.getName());
	}

}