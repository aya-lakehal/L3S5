package game;
import org.junit.*;

import static org.junit.Assert.*;



public class CompetitorTest{
  @Test
  public void testGetName(){
    Competitor c1 = new Competitor("c1");
    assertEquals("c1", c1.getName());
  }
  @Test
  public void testGetPoint(){
    Competitor c1 = new Competitor("c1");
    assertEquals(0,c1.getPoints());

    }
    
    @Test
    public void testIncreaseNbPoints() {
      Competitor c1 = new Competitor("c1");
      assertEquals(0,c1.getPoints());
      c1.increaseNbPoints(2);
      assertEquals(2,c1.getPoints());
      c1.increaseNbPoints(1);
      assertEquals(3,c1.getPoints());
    }

    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(CompetitorTest.class);
	}
    
}