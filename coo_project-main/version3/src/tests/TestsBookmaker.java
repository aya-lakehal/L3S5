package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.Map;

import org.junit.Test;

import model.competition.Competition;
import model.competition.Competitor;
import observers.Bookmaker;
import observers.Journalist;

public class TestsBookmaker extends TestsJournalist {

	@Override
	protected Journalist createJournalist() {
		return new Bookmaker();
	}

	@Override
	protected Journalist createJournalist(PrintStream out) {
		return new Bookmaker(out);
	}

	@Override
	public void testJournalist(Journalist bookmakers, Competition competition) {
		competition.addObserver(bookmakers);

		competition.play();

		Map<Competitor,Integer> cotes = ((Bookmaker) bookmakers).getCotes();
		assertNotNull(cotes);
		assertEquals(cotes.size(), competition.getNbPlayers());
		
		for (Competitor competitor : cotes.keySet()) {
			assertNotNull(competitor);
			Integer cote = cotes.get(competitor);
			assertNotNull(cote);
			assertTrue(cote.intValue() >= 0);
		}
	}
	
	@Test
	@Override
	public void testJournalistMatchWith3Comp() {
		testJournalistMatchWith3Comp("(\\w+ \\(cote \\d+ -> \\d+\\) win versus \\w+ \\(cote \\d+ -> \\d+\\) and \\w+ \\(cote \\d+ -> \\d+\\)\n)");
	}
	
}
