package main;

import game.competition.Competition;
import game.competition.Competitor;
import game.competition.FirstWinner;
import exception.NumberOfCompetitorException;
import game.competition.League;
import game.competition.Master;
import game.competition.StrategyMaster;
import game.competition.Tournament;
import game.match.Match;
import game.match.RandomMatch;
import observer.Bookmaker;
import observer.Journalist;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberOfCompetitorException {
		List<Competitor> competitors = Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"),
                 									 new Competitor("Lynx"), new Competitor("Catalyst"),
                                                     new Competitor("Raven"), new Competitor("Midas"),
				                                     new Competitor("George"), new Competitor("François"),
				                                     new Competitor("Vita"), new Competitor("Slimane"),
				                                     new Competitor("Julie"), new Competitor("Louis"),
				                                     new Competitor("Lucas"), new Competitor("Julien"),
				                                     new Competitor("Antony"), new Competitor("Paul"));
		playAndPrintRankingOfMaster(competitors);
		
	}
	
	
	private static void playAndPrintRankingOfMaster(List<Competitor> competitors) {
		/*try {
			StrategyMaster strategyMaster = new FirstWinner() ;
			Match match = new RandomMatch();
			Competition competition = new Master(competitors, match, strategyMaster, 4 );
			//playAndPrintRanking(competition, new Bookmaker());
		} catch (NumberOfCompetitorException e) {
			e.printStackTrace();
		}*/
	}
	
	/*private static void playAndPrintRanking(Competition competition, Journalist journalist) {
		competition.addObserver(journalist);
		playAndPrintRanking(competition);
	}
	
	private static void playAndPrintRanking(Competition competition) {
		competition.play();
		competition.printRanking();
	}*/

}

