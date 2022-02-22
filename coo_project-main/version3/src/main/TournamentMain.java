package main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import exception.NumberOfCompetitorException;
import game.competition.Competition;
import game.competition.Competitor;
import game.competition.Tournament;
import game.match.Match;
import game.match.RandomMatch;

public class TournamentMain {
	
	
	public static void main(String[] args) throws NumberOfCompetitorException {
		System.out.println("\n*** Tournament***");
		List<Competitor> competitors = Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"),
													 new Competitor("Lynx"), new Competitor("Catalyst"),
												     new Competitor("Raven"), new Competitor("Midas"));
		
		Match match = new RandomMatch();
		Competition competition = new Tournament(competitors, match);
		
		competition.play();
		
		System.out.println("\n*** Ranking ***");
		
		Map<Competitor, Integer> rank = competition.ranking();
		for (Competitor competitor : rank.keySet()) {
			System.out.printf("%s - %d\n", competitor.getName(), competitor.getPoints());
		}

	}
}



