package game.match;

import game.competition.Competitor;

/**
 * 
 */
public class RandomMatch extends Match {
	
	public RandomMatch() {
		super(2);
	}

	@Override
	public Competitor playMatch() {
		int idxRandom = (int) (Math.random()*getNbCompetitors());
		Competitor winnerCompetitor = getCompetitors().get(idxRandom);
		winnerCompetitor.increaseNbWin();
		return thetWinner = winnerCompetitor;
	}
	
}

