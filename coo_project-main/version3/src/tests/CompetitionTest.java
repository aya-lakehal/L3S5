package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import exception.NumberOfCompetitorException;
import game.competition.Competition;
import game.competition.Competitor;


public abstract class CompetitionTest {

	protected abstract Competition createCompetition() throws NumberOfCompetitorException;
	protected abstract int calculateTotalOfPoints(Competition competition);

	
	protected List<Competitor> createListOfCompetitor(final int NB_COMPETITORS) {
		List<Competitor> competitors = new ArrayList<Competitor>();
		for (int i = 1; i <= NB_COMPETITORS; i++) {
			competitors.add(new Competitor("" + i));
		}
		return competitors;
	}
	
	@Test
	public void testCompetitionIsUsedCorrectly() throws NumberOfCompetitorException {
		Competition competition = createCompetition();
		
		competition.play();

		Map<Competitor, Integer> ranks = competition.ranking();
		assertNotNull(ranks);

		int previousValue = Integer.MAX_VALUE;
		for (Competitor competitor : ranks.keySet()) {
			Integer integer = ranks.get(competitor);
			assertNotNull(integer);
			if (integer.intValue() > previousValue) fail("ranks are not sorted");
			previousValue = integer.intValue();
		}
	}
	
	public void testCorrectNumberOfPoints(Competition competition) {
		try {
			competition.play();
		} catch (NumberOfCompetitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<Competitor, Integer> ranks = competition.ranking();
		assertNotNull(ranks);
		int total = 0;
		System.out.println("\n*** Ranking ***");
		for (Competitor competitor : ranks.keySet()) {
			total += ranks.get(competitor);
            System.out.printf("%s - %d\n", competitor.getName(), ranks.get(competitor));
		}
		System.out.println();
	}


	

}