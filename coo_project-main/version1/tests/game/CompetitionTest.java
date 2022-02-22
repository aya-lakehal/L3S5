package game;

import game.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;

public abstract class CompetitionTest {
	protected Competitor c1;
	protected Competitor c2;
	protected Competitor c3;
	protected Competitor c4;

	protected List<Competitor> list=new ArrayList<Competitor>();
	protected  List list2=new ArrayList<Integer>();
	protected  List list3=new ArrayList<Integer>();
	protected Competition competition;

	Match match;
	@Before
    public void init() {
		 this.c1 = new Competitor("c1");
	    this.c2 = new Competitor("c2");
	    this.c3=new Competitor("c3");
        this.c4=new Competitor("c4");    
	   
	    this.match=new RandomMatch();   
	    this.list.add(this.c1);
	    this.list.add(this.c2);
	    this.list.add(this.c3);
	    this.list.add(this.c4);
	    this.competition  =this.createInstance(this.list);
	    
	   
	}
	public abstract Competition createInstance(List<Competitor> c);
	@Test
	public void testRanking() {
		assertFalse(this.createInstance(this.list).ranking().keySet().isEmpty());
		}


	
	
	
	public static junit.framework.Test suite() {
			return new junit.framework.JUnit4TestAdapter(CompetitionTest.class);
		}

}
