package game.competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Abstract class for StrategyMaster
 *
 */
public class TwoFirstWinner implements StrategyMaster {

	private List<Competitor> competitorsFinalPhase;
	
	public TwoFirstWinner() {
		this.competitorsFinalPhase = new ArrayList<>();
	}
	
	
	public List<Competitor> selectCompetitorsOfFinalPhase(List<Map<Competitor, Integer>> ranks) {
	
		
		List<List<Competitor>> allKey = new ArrayList<>();
		
		for (Map<Competitor, Integer> r: ranks) {
			List<Competitor> key = new ArrayList<>();
			for(@SuppressWarnings("rawtypes") Map.Entry elt : r.entrySet()) {
				key.add((Competitor) elt.getKey());
			}
			
			allKey.add(key);
		}
		
		for(List<Competitor> eltAllKey : allKey) {
			Competitor first = eltAllKey.get(0);
			Competitor two = eltAllKey.get(1);
			this.competitorsFinalPhase.add(first);
			this.competitorsFinalPhase.add(two);
		}
		
		return competitorsFinalPhase;
		
	}

	@Override
	public List<Competitor> getCompetitors() {
		return this.competitorsFinalPhase;
	}
	
	
}
