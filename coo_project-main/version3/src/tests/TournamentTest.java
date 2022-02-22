package tests;

import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.Test;

import exception.NumberOfCompetitorException;
import game.competition.Competition;
import game.competition.Competitor;
import game.competition.Tournament;
import game.match.Match;
import game.match.RandomMatch;

public class TournamentTest extends CompetitionTest {
	
	@Override
	protected Competition createCompetition() throws NumberOfCompetitorException {
		List<Competitor> competitors = createListOfCompetitor(8);
		Match match = new RandomMatch();
		return new Tournament(competitors,match);
	}
	@Test
	public void testTournamentIncorrectNumberOfCompetitors() { // throws NumberForCompetitionException {
		final int NB_COMPETITORS = 10;
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		Match match = new RandomMatch();
		assertThrows(NumberOfCompetitorException.class, () -> new Tournament(competitors,match));
	}
	
	@Test
	public void testTournamentCorrectTotalOfCompetitorsPoints() throws NumberOfCompetitorException {
		final int NB_COMPETITORS = 8;
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		Match match = new RandomMatch();
		Tournament tournament = new Tournament(competitors,match);
		
		testCorrectNumberOfPoints(tournament);
	}
	@Override
	protected int calculateTotalOfPoints(Competition competition) {
		// TODO Auto-generated method stub
		return 0;
	}



}