package game;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class LeagueTest extends CompetitionTest  {



	protected Competition competition;

	public Competition createInstance(List<Competitor> c) {
		Match match = new RandomMatch();
		return new League(c,match) ;
	}
	
	@Test
	public void testPlay() {
		this.competition.playMatch(c1,c2);
		assertFalse(this.c1.getPoints()==c2.getPoints());
	}
	
	@Test
	public void testPlayMatch() {
		this.competition.playMatch(c1,c2);
		assertFalse(c1.getPoints()==c2.getPoints());
	}

	 public static junit.framework.Test suite() {
			return new junit.framework.JUnit4TestAdapter(LeagueTest.class);
     }









}
