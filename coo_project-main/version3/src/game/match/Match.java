package game.match;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import game.competition.Competitor;

/**
 * 
 */
public abstract class Match {
	//liste des joeurs
	private final List<Competitor> competitors;
	//nombre des joeurs
	private final int nbCompetitors;
	//le vinqueur
	
	protected Competitor thetWinner;
	public Match(int nbPlayers) {
		this.competitors = new ArrayList<Competitor>();
		this.nbCompetitors = nbPlayers;
	}

	public abstract Competitor playMatch();
	/* getters of competitors and number of competitors */
	
	public List<Competitor> getCompetitors() {
		return competitors;
	}

	public int getNbCompetitors() {
		return nbCompetitors;
	}

	/**
	 * Add the competitor on parameter if there are not too much players.
	 * 
	 * @param c Competitor
	 * @return true if there are not too much players, false otherwise.
	 */
	public boolean addCompetitor(Competitor c) {
		if (competitors.size() < nbCompetitors) {
			return competitors.add(c);
		} else {
			return false;
		}
	}

	/**
	 * Add all competitors on parameter if there are not too much players.
	 * 
	 * @param cc Collection of Competitor
	 * @return true if there are not too much players, false otherwise.
	 */
	public boolean addAllCompetitors(Collection<Competitor> cc) {
		boolean success = true;
		Iterator<Competitor> iterator = cc.iterator();
		while (success && iterator.hasNext()) {
			success &= addCompetitor(iterator.next());
		}
		return success;
	}

	public boolean removeCompetitor(Competitor c) {
		return competitors.remove(c);
	}

	public void clearCompetitor() {
		competitors.clear();
	}

	public Competitor theWinner() {
		return thetWinner;
	}

}
