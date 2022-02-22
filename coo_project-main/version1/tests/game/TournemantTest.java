package game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TournemantTest extends CompetitionTest {

	@Override
	public Competition createInstance(List<Competitor> c) {
		Match match = new RandomMatch();
		return new Tournament(c,match) ;
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
			return new junit.framework.JUnit4TestAdapter(TournemantTest.class);
  }


}
