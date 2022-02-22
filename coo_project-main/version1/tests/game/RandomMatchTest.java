package game;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import game.Competition;

public class RandomMatchTest extends MatchTest {
	protected Competition competition;
	
	@Test
	public void testTheWinner() {
		Match match = new RandomMatch();
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		this.competition.playMatch(c1,c2);
		assertTrue(match.contains(match.theWinner(c1,c2)));
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(RandomMatchTest.class);
	}



}