package observer;

import java.io.PrintStream;
import java.util.List;

import game.competition.Competitor;
import game.match.Match;
import game.match.RandomMatch;


public class Journalist implements MatchObserver {
	
	protected PrintStream out;
	
	public Journalist() {
		this.out = System.out;
	}
	
	public Journalist(PrintStream out) {
		this.out = out;
	}
	
	@Override
	public void update(ObservableMatch arg0, Match match) {
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		Competitor lastWinner = match.theWinner();  //le dernier gangnat
		
		
		
		
		
		StringBuffer sb = new StringBuffer(String.format("%s win versus ", lastWinner.getName()));
		
		boolean alreadyPrintName = false;
		List<Competitor> players = match.getCompetitors(); //list des joeurs dans le match
		for (int idx = 0; idx < players.size(); idx++) {
			Competitor competitor = players.get(idx);
			if (competitor != lastWinner) {
				sb.append(String.format("%s%s", alreadyPrintName?" and ":"",competitor.getName()));
				alreadyPrintName = true;
			}
		}
		
		this.out.printf(sb.append("\n").toString());
		
	}




}