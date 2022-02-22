package game.competition;

import java.util.List;
import java.util.Map;

/**
 * Interface for the Strategy of Masters.
 * 
 *
 */
public interface StrategyMaster {

	/**
	 * Select competitors who will participate in the final phase. 
	 * @param pools League[]
	 */
	public List<Competitor> selectCompetitorsOfFinalPhase(List<Map<Competitor, Integer>> ranks); //selectionner les joeurs qui sont qualifiés
	
	
	public List<Competitor> getCompetitors() ;
	
}

