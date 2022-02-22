package game;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
/**
 * the class Main to start the game 
 */


public class Main {

	public static void main(String[] args) {

		List<Competitor> competitors = Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"),
													 new Competitor("Lynx"), new Competitor("Catalyst"),
													 new Competitor("Raven"), new Competitor("Midas"));
		
		Match match = new RandomMatch();
		Competition competition = new League(competitors, match);

		competition.play();

		System.out.println("\n*** Ranking ***");

		Map<Competitor, Integer> rank = competition.ranking();
		for (Competitor competitor : rank.keySet()) {
            System.out.printf("%s - %d\n", competitor.getName(), competitor.getPoints());
        }

	}

}