package main;

import java.util.Arrays;
import java.util.List;

import displayer.ConsoleDisplayer;
import exception.NumberOfCompetitorException;
import game.competition.Competition;
import game.competition.Competitor;
import game.competition.FirstWinner;
import game.competition.Master;
import game.competition.StrategyMaster;
import game.match.Match;
import game.match.RandomMatch;

public class MasterMain {
	public static void main(String[] args) throws NumberOfCompetitorException  {
		
		
		List<Competitor> competitors = Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"),
				 	                                 new Competitor("Lynx"), new Competitor("Catalyst"),
				                                     new Competitor("Raven"), new Competitor("Midas"),
													 new Competitor("George"), new Competitor("François"),
                                                     new Competitor("Vita"), new Competitor("Slimane"),
                                                     new Competitor("Julie"), new Competitor("Louis"),
				                                     new Competitor("Lucas"), new Competitor("Julien"),
				                                
                                                     new Competitor("Antony"), new Competitor("Paul"));
				
		StrategyMaster strategyMaster = new FirstWinner() ;
		Match match = new RandomMatch();
		Competition competition = new Master(competitors, match, strategyMaster, 4, new ConsoleDisplayer() );
		
		competition.play();
		
		System.out.println(competition.theOfficialWinner().getName()+" Wins The Master! ");
	}
	
}


