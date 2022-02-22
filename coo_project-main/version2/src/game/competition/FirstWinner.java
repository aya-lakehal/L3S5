package game.competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FirstWinner implements StrategyMaster {
	private List<Competitor> competitorsFinalPhase;
	
	public FirstWinner() {
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
			this.competitorsFinalPhase.add(first);
		}
		
		return competitorsFinalPhase;
		
	}

	@Override
	public List<Competitor> getCompetitors() {
		return this.competitorsFinalPhase;
	}
}
