package observer;

import java.io.PrintStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.competition.Competitor;
import game.match.Match;

/**
 * A class which simulate a Bookmaker.
 * 
 */
public class Bookmaker extends Journalist {
	
	private Map<Competitor, Integer> cotes = new HashMap<Competitor, Integer>();
	
	public Bookmaker() {
		super();
	}
	
	public Bookmaker(PrintStream out) {
		super(out);
	}
	
	@Override
	public void update(ObservableMatch arg0, Match match) {
		
		Competitor lastWinner = match.theWinner(); //le dernier gagnat
		
		Integer integer = addCoteToCompetitor(lastWinner);

		StringBuffer sb = new StringBuffer(String.format("%s (cote %d -> %d) win versus ", lastWinner.getName(), integer-1, integer));

		boolean alreadyPrintName = false;
		List<Competitor> players = match.getCompetitors();// list des joeurs 
		for (int idx = 0; idx < players.size(); idx++) {
			Competitor competitor = players.get(idx);
			if (competitor != lastWinner) {
				Integer integer2 = removeCoteToCompetitor(competitor);

				sb.append(String.format("%s%s (cote %d -> %d)", alreadyPrintName?" and ":"", competitor.getName(), integer2+1, integer2));
				alreadyPrintName = true;
			}
		}
		
		this.out.printf(sb.append("\n").toString());
		
	}
	
	private Integer addCoteToCompetitor(Competitor competitor) {
		return cotes.compute(competitor, (k, v) -> (v==null?0:v)+1);
	}
	
	private Integer removeCoteToCompetitor(Competitor competitor) {
		return cotes.compute(competitor, (k, v) -> (v==null?0:(v>0?v-1:v)));
	}
	
	public Map<Competitor, Integer> getCotes() {
		return cotes;
	}

}