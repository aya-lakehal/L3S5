package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.platform.engine.support.discovery.SelectorResolver.Match;

import exception.NumberOfCompetitorException;
import game.match.RandomMatch;
import game.competition.Competition;
import game.competition.Competitor;
import game.competition.League;

public class LeagueTest extends CompetitionTest {

	@Override
	protected Competition createCompetition() {
		List<Competitor> competitors = new ArrayList<Competitor>();
		RandomMatch match = new RandomMatch();
		competitors.add(new Competitor("1"));
		competitors.add(new Competitor("2"));
		return new League(competitors,match);
	}


	
	@Test
	public void testLeaguePointsAreNotOverAbused() throws NumberOfCompetitorException {
		final int NB_COMPETITORS = 10;
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		RandomMatch match = new RandomMatch();
		Competition competition = new League(competitors,match);
		
		competition.play();
		
		Map<Competitor, Integer> ranks = competition.ranking();
		assertNotNull(ranks);
		int total = 0;
		for (Competitor competitor : ranks.keySet()) { 
			Integer integer = ranks.get(competitor);
			assertNotNull(integer);
			assertEquals(competitor.getPoints(), integer.intValue());
			assertTrue(integer.intValue() <= 2*NB_COMPETITORS);
			total += integer.intValue();
		}
		assertEquals(total, NB_COMPETITORS*(NB_COMPETITORS-1));
	}
	
	public void testCorrectNumberOfPointsLeague(final int NB_COMPETITORS) throws NumberOfCompetitorException {
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		RandomMatch match = new RandomMatch();
		Competition competition = new League(competitors,match);
		
		testCorrectNumberOfPoints(competition);
	}
	
	@Test
	public void testCorrectNumberOfPointsLeague() throws NumberOfCompetitorException {
		for (int nbPlayer = 2; nbPlayer < 32; nbPlayer++) {
			testCorrectNumberOfPointsLeague(nbPlayer);
		}
	}



	@Override
	protected int calculateTotalOfPoints(Competition competition) {
		// TODO Auto-generated method stub
		return 0;
	}

}