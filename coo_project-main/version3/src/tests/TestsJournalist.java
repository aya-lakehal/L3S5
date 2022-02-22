package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

import model.competition.Competition;
import model.competition.Competitor;
import model.competition.CompetitorBasic;
import model.competition.InadequateNumberForCompetitionException;
import model.competition.League;
import model.competition.Master;
import model.competition.Tournament;
import model.competition.MasterStrategies.Master1Retrivials0Pools2Comp8;
import model.match.Match;
import observers.Journalist;

public class TestsJournalist {
	
	private List<Competitor> createListOfCompetitor() {
		return Arrays.asList(new CompetitorBasic("Blastoff"), new CompetitorBasic("Drift"),
				 new CompetitorBasic("Lynx"), new CompetitorBasic("Catalyst"),
				 new CompetitorBasic("Raven"), new CompetitorBasic("Midas"),
				 new CompetitorBasic("Gon"), new CompetitorBasic("Killua"));
	}
	
	protected Journalist createJournalist() {
		return new Journalist();
	}
	
	protected Journalist createJournalist(PrintStream out) {
		return new Journalist(out);
	}

	public ByteArrayInputStream testJournalist(Competition competition) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		assertNotNull(out);
		
		Journalist journalist = createJournalist(out);
		
		testJournalist(journalist, competition);
		
		ByteArrayInputStream in = new ByteArrayInputStream((baos.toByteArray()));
		assertNotNull(in);
		assertNotEquals(in.read(), -1);
		in.reset();
		return in;
	}
	
	public void testJournalist(Journalist journalist, Competition competition) {
		competition.addObserver(journalist);

		competition.play();
	}
	

	@Test
	public void testJournalistMaster() throws InadequateNumberForCompetitionException {
		List<Competitor> competitors = createListOfCompetitor();

		Competition competition = new Master(competitors, new Master1Retrivials0Pools2Comp8());
			
		testJournalist(competition);
		testJournalist(createJournalist(), competition);
	}
	
	@Test
	public void testJournalistTournament() throws InadequateNumberForCompetitionException {
		List<Competitor> competitors = createListOfCompetitor();

		Competition competition = new Tournament(competitors);

		testJournalist(competition);
		testJournalist(createJournalist(), competition);
	}
	
	@Test
	public void testJournalistLeague() {
		List<Competitor> competitors = createListOfCompetitor();
		
		Competition competition = new League(competitors);

		testJournalist(competition);
		testJournalist(createJournalist(), competition);
	}
	
	@Test
	public void testJournalistFunctions() {
		List<Competitor> competitors = createListOfCompetitor();
		
		Competition competition = new League(competitors);
		assertEquals(0, competition.countObservers());
		
		Journalist journalist = createJournalist();
		
		competition.addObserver(journalist);
		assertEquals(1, competition.countObservers());
		
		competition.addObserver(createJournalist());
		assertEquals(2, competition.countObservers());
		
		competition.deleteObserver(journalist);
		assertEquals(1, competition.countObservers());
		
		competition.addObserver(journalist);
		assertEquals(2, competition.countObservers());
		
		competition.deleteObservers();
		assertEquals(0, competition.countObservers());
	}
	
	@Test
	public void testJournalistMatchWith3Comp() {
		testJournalistMatchWith3Comp("(\\w+ win versus \\w+ and \\w+\n)");
	}
	
	public void testJournalistMatchWith3Comp(String regexLine) {
		List <Competitor> competitors = Arrays.asList(new CompetitorBasic("Blastoff"), new CompetitorBasic("Drift"), new CompetitorBasic("Lynx"), new CompetitorBasic("Catalyst"));
		Competition competition = new LeagueMock(competitors);
		ByteArrayInputStream in = testJournalist(competition);
		
		assertTrue(Pattern.matches(regexLine + "{"+(competitors.size()*(competitors.size()-1)*(competitors.size()-2))+"}", new String(in.readAllBytes())));
		//System.out.println("testJournalistMatchWith3C : " + new String(in.readAllBytes()) + " : testJournalistMatchWith3C");
	}
	
	class LeagueMock extends League {

		public LeagueMock(List<Competitor> competitors) {
			super(competitors, new MatchMock());
		}
		
		@Override
		protected void play(List<Competitor> cps) {
			for (Competitor c1 : cps) {
				for (Competitor c2 : cps) {
					for (Competitor c3 : cps) {
						if (c1 != c2 && c1 != c3 && c2 != c3) {
							playMatch(c1, c2, c3);
						}
					}
				}
			}
		}

		protected void playMatch(Competitor c1, Competitor c2, Competitor c3) {
			getMatch().clearPlayers();
			getMatch().addPlayer(c1);
			getMatch().addPlayer(c2);
			getMatch().addPlayer(c3);
			Competitor winnerCompetitor = getMatch().playMatch();
			addPointToCompetitor(winnerCompetitor);
			//setChanged();
			notifyObservers(getMatch());
			System.out.printf("%s vs %s and %s --> %s wins!\n", c1.getName(), c2.getName(), c3.getName(), winnerCompetitor.getName());
		}
		
	}
	
	class MatchMock extends Match {

		public MatchMock() {
			super(3);
		}

		@Override
		public Competitor playMatch() {
			Competitor winnerCompetitor = getPlayers().get(0);
			winnerCompetitor.increaseNbWin();
			return lastWinner = winnerCompetitor;
		}
		
	}
	
}
